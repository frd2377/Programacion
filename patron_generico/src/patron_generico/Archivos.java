package patron_generico;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivos {
	private Generica<String, File> datosArchivo = new Generica<String, File>();
	private Boolean flag = false;
	
	public Archivos(String absolutePath) {
		datosArchivo.setAtributo1(absolutePath);
		datosArchivo.setAtributo3(new File(absolutePath));
	}
	
	public boolean writerFile(String text, boolean allow) throws IOException {
		FileWriter archivo = new FileWriter(datosArchivo.getAtributo3().getAbsolutePath(), !allow);
		archivo.write(text);
		archivo.close();
		return true;
	}
	
	public String readerFile() throws IOException {
		datosArchivo.setAtributo2("");
		FileReader reader = new FileReader(datosArchivo.getAtributo3().getAbsolutePath());
		int caracteres;
		while ((caracteres= reader.read()) != -1) {
			datosArchivo.setAtributo2(datosArchivo.getAtributo2()+String.valueOf((char) caracteres));
		}
		reader.close();
		return datosArchivo.getAtributo2();
	}
	
	public Boolean create(int tipo) {
		switch (tipo) {
		case 0:
			if (!datosArchivo.getAtributo3().exists()) {
				flag = datosArchivo.getAtributo3().mkdir();
			}
			break;
		case 1:
			if (!datosArchivo.getAtributo3().exists()) {
				try {
					flag = datosArchivo.getAtributo3().createNewFile();
				} catch (IOException e) {
					flag = false;
				}
			}
			
			break;
		default:
			flag=false;
			break;
		}
		return flag;
	}
	
	public static boolean validacionByER(String text, String er) {
		return text.matches(er);
	}
	
	public static String searchReplace(String text, String replace, String searchWord) {
		Pattern patron = Pattern.compile(searchWord);
		Matcher analisis = patron.matcher(text);
		return analisis.replaceAll(replace);
	}
	
	public File getFile() {
		return datosArchivo.getAtributo3();
	}
	
	public void setFile(File newFile) {
		datosArchivo.setAtributo3(newFile);
	}
	
	public String[] listFiles() {
		if (datosArchivo.getAtributo3().isDirectory()) {
			return datosArchivo.getAtributo3().list();
		}else {
			return null;
		}
	}
	
	// devolver un listado de archivos o directorios
	// param tipo -> tipo == 1 retornar directorios, tipo == 0 retorna archivos
	// return String []
	public List<String> listFilesoDirectory(int tipo) {
		datosArchivo.atributoArray1 = listFiles();
		
		if (datosArchivo.atributoArray1.length > 0) {
			for (String file : datosArchivo.atributoArray1) {
				datosArchivo.setAtributo4(new File(datosArchivo.getAtributo3().getAbsolutePath()+"/"+file));
				if (tipo == 1) {
					if (datosArchivo.getAtributo4().isDirectory()) {
						datosArchivo.addElemntos(file);
					}
				}else if(tipo == 0){
					if (datosArchivo.getAtributo4().isFile()) {
						datosArchivo.addElemntos(file);
					}
				}
			}
		}
		
		return datosArchivo.getElementos();
	}
	
	public boolean getFileChooser(JFrame frame, String extension) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(extension+"files", new String[] {extension}));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int flag_ = fileChooser.showOpenDialog(frame);
		if (flag_ == fileChooser.APPROVE_OPTION) {
			setFile(new File(fileChooser.getSelectedFile().getAbsolutePath()));
			return true;
		}else {
			return false;
		}
	
	}
	
	public List<String> findWords(String text, String er) {
		Pattern patron = Pattern.compile(er);
		datosArchivo.atributoArray1 = text.split("(\\s+|[,.;])");
		for (String word : datosArchivo.atributoArray1) {
			Matcher analisis = patron.matcher(word);
			if (analisis.find()) {
				datosArchivo.addElemntos(analisis.group());
			}
		}
		return datosArchivo.getElementos();
	}
	
}
