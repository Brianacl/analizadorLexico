package Lex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//clase de los token devueltos
class Yytoken {
    Yytoken (int numToken,String token, String tipo, int linea, int columna){
        //Contador para el número de tokens reconocidos
        this.numToken = numToken;
        //String del token reconocido
        this.token = new String(token);
        //Tipo de componente léxico encontrado
        this.tipo = tipo;
        //Número de linea
        this.linea = linea;
        //Columna donde empieza el primer carácter del token
        this.columna = columna;
    }

//Métodos de los atributos de la clase
    public int numToken;
    public String token;
    public String tipo;
    public int linea;
    public int columna;
    //Metodo que devuelve los datos necesarios que escribiremos en un archive de salida
    public String toString() {
        return "Token #"+numToken+": "+token+" C.Lexico: "+tipo+" ["+linea
        + "," +columna + "]";
    }
}
/* Seccion de opciones y declaraciones de JFlex */
%% //inicio de opciones
//Cambiamos el nombre la funcion para el siguiente token por nextToken
%function nextToken
//Clase publica
%public
//Cambiamos el nombre de la clase del analizador
%class AnalizadorLexico
//Agregamos soporte a unicode
%unicode

//Codigo java
%{
	
    private int contador;
    private ArrayList<Yytoken> tokens;

	private void writeOutputFile() throws IOException{
			String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(Yytoken t: this.tokens){
				System.out.println(t);
				out.write(t + "\n");
			}
			out.close();
	}
%}

//Creamos un contador para los tokens
%init{
    contador = 0;
	tokens = new ArrayList<Yytoken>();
%init}
//Cuando se alcanza el fin del archivo de entrada
%eof{
	try{
		this.writeOutputFile();
        //System.exit(0);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
%eof}

//Activar el contador de lineas, variable yyline
%line
//Activar el contador de columna, variable yycolumn
%column
//Fin de opciones

//Expresiones regulares
//Declaraciones
EXP_ALPHA_MINUS=[a-z]
EXP_ALPHA=[A-Za-z_]
EXP_DIGITO=[0-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
NUMERO=({EXP_DIGITO})+
IDENTIFICADOR={EXP_ALPHA_MINUS}({EXP_ALPHANUMERIC})*
ESPACIO=" "
SALTO=\n|\r|\r\n
//fin declaraciones

/* Seccion de reglas lexicas */
%% 
//Regla     {Acciones}

{NUMERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"num",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"IniciaPrograma"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IniciaPrograma",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"si"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"si",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"funcion"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"funcion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"sino"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"sino",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"ciclo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ciclo",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"entero"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"entero",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"flotante"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"flotante",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"verdad"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"verdad",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"falso"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"falso",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"config"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"config",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"salidaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"salidaDato",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"entradaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"entradaDato",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"compuertaAbierta"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"compuertaAbierta",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"compuertaCerrada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"compuertaCerrada",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"comprimir"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"comprimir",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"detectarParada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarParada",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"detectarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarAnomalia",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"vaciarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"vaciarContenedor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"capacidadContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"capacidadContenedor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"estadoLinea"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"estadoLinea",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"sobrecupo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"sobrecupo",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"avanzar"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"avanzar",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"detener"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detener",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"estadoEnergia"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"estadoEnergia",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"detectarSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarSensor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"modalidadSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"modalidadSensor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"ENTRADA"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ENTRADA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"SALIDA"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SALIDA",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"ALTO"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ALTO",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"vaciarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"vaciarContenedor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"soltarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"soltarContenedor",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"temporizador"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"temporizador",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"mientras"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mientras",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"vaciarCamion"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"vaciarCamion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{IDENTIFICADOR}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"id",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asignacion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"=="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"comparacion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asignacion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"<"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"menor_que",yyline,yycolumn);
    tokens.add(t);
    return t;
}

">"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mayor_que",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"<="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"menor_igual",yyline,yycolumn);
    tokens.add(t);
    return t;
}

">="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mayor_igual",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"!="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"diferente_de",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"+"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"suma",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"-"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"resta",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"*"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"multiplicacion",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"/"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"division",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"++"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"incremento",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"--"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"decremento",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"+="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"suma_asigna",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"-="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"resta_asigna",yyline,yycolumn);
    tokens.add(t);
    return t;
}

"*="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"multipli_asinga",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{ESPACIO} {
 	//ignorar
}

{SALTO} {
    contador++;
    Yytoken t = new Yytoken(contador,"","fin_linea",yyline,yycolumn);
    tokens.add(t);
    return t;
}
