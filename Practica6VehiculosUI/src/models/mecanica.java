package models;

public class mecanica {
	private vehiculo vh;
	public mecanica(vehiculo vh_) {
		this.vh=vh_;
	}
	
	public double T_lambda(double lambda) {
		lambda-=1;
		lambda*=100/1;//Calcula el %
		if(lambda<0) lambda=0;
		return lambda;
	}
	public double T_O2(double O2) {
		O2-=2;
		O2*=100/2;//Calcula el % de O2
		if(O2<0) O2=0;
		return O2;
	}
	public double T_N2O(double N2O) {
		N2O-=40;
		N2O*=100/40;
		if(N2O<0) N2O=0;
		return N2O;
	}
	public double T_CO2(double CO2) {
		CO2-=15;
		CO2*=100/15;
		if(CO2<0) CO2=0;
		return CO2;
	}
	public String msg_lambda(double T_lambda) {
		if(T_lambda<=70) return "Pasa en primera revisión";
		else return "Segunda revision";
	}
	public String msg_O2(double T_O2) {
		if(T_O2<=30) return "Pasa en primera revisión";
		else return "Segunda revision";
	}
	public String msg_N2O(double T_N2O) {
		if(T_N2O<=80) return "Pasa en primera revisión";
		else return "Segunda revision";
	}
	public String msg_CO2(double T_CO2) {
		if(T_CO2<=50) return "Pasa en primera revisión";
		else return "Segunda revision";
	}
	public String toString() {
		return String.format("MARCA: %s PLACA: %s %n"
				+ "LAMBDA: %.2f%% %s %n"
				+ "O2:     %.2f%% %s %n"
				+ "N2O:    %.2f%% %s %n"
				+ "CO2:    %.2f%% %s %n", 
				vh.getMarca(), vh.getPlaca(),
				T_lambda(vh.getLambda()), msg_lambda(T_lambda(vh.getLambda())),
				T_O2(vh.getO2()), msg_O2(T_O2(vh.getO2())),
				T_N2O(vh.getN2O()), msg_N2O(T_N2O(vh.getN2O())),
				T_CO2(vh.getCO2()), msg_CO2(T_CO2(vh.getCO2()))
				);
	}

}
