package controllers;

import patron.Generica;

public class controllerRevisionUi {
		
		public static double T_lambda(double lambda) {
			lambda-=1;
			lambda*=100/1;//Calcula el %
			if(lambda<0) lambda=0;
			return lambda;
		}
		public static double T_O2(double O2) {
			O2-=2;
			O2*=100/2;//Calcula el % de O2
			if(O2<0) O2=0;
			return O2;
		}
		public static double T_N2O(double N2O) {
			N2O-=40;
			N2O*=100/40;
			if(N2O<0) N2O=0;
			return N2O;
		}
		public static double T_CO2(double CO2) {
			CO2-=15;
			CO2*=100/15;
			if(CO2<0) CO2=0;
			return CO2;
		}
		public static String msg_lambda(double T_lambda) {
			if(T_lambda<=70) return "Pasa en primera revisión";
			else return "Segunda revision";
		}
		public static String msg_O2(double T_O2) {
			if(T_O2<=30) return "Pasa en primera revisión";
			else return "Segunda revision";
		}
		public static String msg_N2O(double T_N2O) {
			if(T_N2O<=80) return "Pasa en primera revisión";
			else return "Segunda revision";
		}
		public static String msg_CO2(double T_CO2) {
			if(T_CO2<=50) return "Pasa en primera revisión";
			else return "Segunda revision";
		}

}
