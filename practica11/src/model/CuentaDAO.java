package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import patron_generico.Generica;
import patron_generico.connection;

public class CuentaDAO {
	
	private Generica<String, String> dataDAO;
	private Cuenta cuenta;
	private connection connection = new connection("practica11");
	private ResultSet resultSet;
	
	public CuentaDAO() {
		dataDAO = new Generica<String, String>();
		dataDAO.addElemntos("Ahorros");
		dataDAO.addElemntos("Corriente");
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public synchronized void registerCuenta() {
		cuenta = new Cuenta(Long.parseLong(genNumeroDeCuenta()), dataDAO.getElementos().get(genTipoCuenta()), Integer.parseInt(genDNI()), genSaldo());
		ResultSet resultSet = connection.getQuery("select * from banco.cuenta where num_cuenta="+cuenta.getNumCuenta()+" and "+"cedula_pro="+cuenta.getDni());		
		try {
			if (!resultSet.next()) {
				connection.setQuery("insert into banco.cuenta values(null, '" + cuenta.getNumCuenta() + "','" + cuenta.getTipo() + "', " + cuenta.getDni() + ", " + cuenta.getSaldo() + ")");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized List<Cuenta> getCuentas(){
		 List<Cuenta> cuentas = new ArrayList<Cuenta>();
		 resultSet = connection.getQuery("select * from banco.cuenta");
		 try {
			while(resultSet.next()) {
				 cuentas.add(new Cuenta(
						 resultSet.getInt(1),
						 resultSet.getLong(2),
						 resultSet.getString(3),
						 resultSet.getInt(4),
						 resultSet.getDouble(5)
						 ));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cuentas;
	}
	
	public synchronized boolean updateCuenta() {
	    return connection.setQuery("update banco.cuenta set num_cuenta='" + cuenta.getNumCuenta() +
	                                "', tipo_cuenta='" + cuenta.getTipo() +
	                                "', cedula_pro=" + cuenta.getDni() +
	                                ", saldo=" + cuenta.getSaldo() +
	                                " where id_cuenta=" + cuenta.getId());
	}
	
	public synchronized boolean deleteCuenta() {
		return connection.setQuery("delete from banco.cuenta where id_cuenta="+cuenta.getId());
	}
	
	private String genNumeroDeCuenta() {
        Random random = new Random();
        StringBuilder numeroDeCuenta = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            numeroDeCuenta.append(random.nextInt(10));
        }
        return numeroDeCuenta.toString();
    }

    private String genDNI() {
        Random random = new Random();
        StringBuilder dni = new StringBuilder("1");
        for (int i = 0; i < 6; i++) {
            dni.append(random.nextInt(10));
        }
        return dni.toString();
    }
    
    private double genSaldo() {
        double min = 1000.0;
        double max = 5000.0;
        double rango = max - min;
        Random random = new Random();
        double numeroAleatorio = random.nextDouble() * rango + min;
        DecimalFormat formato = new DecimalFormat("#.##");
        String saldoFormateado = formato.format(numeroAleatorio);
        return Double.valueOf(saldoFormateado.replace(",", "."));
    }

    
	private int genTipoCuenta() {
        int min = 0;
        int max = 1;
        int rango = max - min;
        Random random = new Random();
        int numeroAleatorio = random.nextInt(rango + 1) + min;
        return numeroAleatorio;
    }
	
}
