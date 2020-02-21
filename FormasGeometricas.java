package aula3;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FormasGeometricas {
	int tipo;
	double area, base, altura, lado, raio;
	static ArrayList<FormasGeometricas> triangulos = new ArrayList<FormasGeometricas>();
	static ArrayList<FormasGeometricas> quadrilateros = new ArrayList<FormasGeometricas>();
	static ArrayList<FormasGeometricas> circulos = new ArrayList<FormasGeometricas>();
	
	public static FormasGeometricas criarObj () {
		FormasGeometricas obj = new FormasGeometricas();
		return obj;
	}
	
	public static void informarTipo() {
		int opc;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair\n"
			+ "1 - Triangulo\n"
			+ "2 - Quadrilátero\n"
			+ "3 - Círculo \n"
			+ "4 - Imprimir Resultados\n"));
			
			if (opc == 0) {
				System.exit(0);
			}
	
		verificaTipo(opc, criarObj());
		
		}while(opc != 0);
	}
	
	public static void verificaTipo(int tipo, FormasGeometricas fg) {
		
		fg.tipo = tipo;
		
		switch (tipo) {
		
			case 1:
				fg.base = Double.parseDouble(JOptionPane.showInputDialog("Valor da base"));
				fg.altura = Double.parseDouble(JOptionPane.showInputDialog("Valor da altura"));
				calcAreaTriangulo(fg.base, fg.altura, fg);
				armazenarObjeto(fg, triangulos);
				break;
				
			case 2:
				fg.base = Double.parseDouble(JOptionPane.showInputDialog("Valor do lado x"));
				fg.altura = Double.parseDouble(JOptionPane.showInputDialog("Valor do lado y"));
				calcAreaQuadri(fg.base, fg.altura, fg);
				armazenarObjeto(fg, quadrilateros);
			break;
			
			case 3:
				fg.raio = Double.parseDouble(JOptionPane.showInputDialog("Valor da raio"));
				calcAreaCirculo(fg.raio, fg);
				armazenarObjeto(fg, circulos);
			break;
			
			case 4:
				fg.imprimirResultados(fg);
			break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida! Digite novamente");
				informarTipo();
		}
	}
	
	public static void calcAreaTriangulo (double b, double h, FormasGeometricas fg) {
		fg.area = b * h / 2;
	}
	
	public static void calcAreaQuadri (double b, double h, FormasGeometricas fg) {
		fg.area = b * h;
	}
	
	public static void calcAreaCirculo (double r, FormasGeometricas fg) {
		fg.area = Math.PI *(r * r);
	}
	
	public static void armazenarObjeto (FormasGeometricas fg, ArrayList<FormasGeometricas> listaFiguras) {
		listaFiguras.add(fg);
	}
	
	public void imprimirResultados (FormasGeometricas fg) {
	
		if(!triangulos.isEmpty()){
			for(FormasGeometricas fig : triangulos) {
				JOptionPane.showMessageDialog(null, "Área do triângulo '" + fig + "' = " + fig.area);
			}
			
			triangulos.clear();
		}
		
		if(!quadrilateros.isEmpty()){
			for(FormasGeometricas fig : quadrilateros) {
				JOptionPane.showMessageDialog(null, "Área do quadrilátero '" + fig + "' = " + fig.area);
			}
			quadrilateros.clear();
		}
		
		if(!circulos.isEmpty()){
			for(FormasGeometricas fig : circulos) {
				JOptionPane.showMessageDialog(null, "Área do círculo '" + fig + "' = " + fig.area);
			}
			circulos.clear();
		}
		
	}
	
	public static void main(String [] args) {
		informarTipo();
	}
}