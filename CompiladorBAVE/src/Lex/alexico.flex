package Lex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//clase de los token devueltos
class Yytoken {
    Yytoken (int numToken,String token, String tipo, int linea, int columna, boolean error){
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

        this.error = error;
    }

//Métodos de los atributos de la clase
    public int numToken;
    public String token;
    public String tipo;
    public int linea;
    public int columna;
    public boolean error;
    //Metodo que devuelve los datos necesarios que escribiremos en un archivo de salida
    public String toString() {
        if(error){
            return token +": "+ tipo+" | [Linea: "+linea+"]";
        }
        return "Token #"+numToken+": "+token+" | Componente léxico: "+tipo+" [Linea: "+linea+"]";
    }
}//Fin clase Yytoken
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
    private boolean eliminar;

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
    eliminar = false;
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
SIGNO = [-+]
EXP_ALPHA_MINUS=[a-z]
EXP_ALPHA_MAYUS=[A-Z]
EXP_ALPHA=[A-Za-z_áéíóú]
EXP_DIGITO=[0-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
ENTERO={SIGNO}({EXP_DIGITO})+ | ({EXP_DIGITO})+
FLOTANTE ={SIGNO}({EXP_DIGITO})+.({EXP_DIGITO})+ | ({EXP_DIGITO})+.({EXP_DIGITO})+ 
EXPONENTE = {FLOTANTE}(E|e){ENTERO} | {ENTERO}(E|e){ENTERO}
ID={EXP_ALPHA_MINUS}({EXP_ALPHANUMERIC})*
ESPACIO=" "
CARAC_ESPECIAL=[@!%&#¿?',.]
SALTO=\n|\r|\r\n|\t
NUMERO_INVALIDO = .({EXP_DIGITO})+ | ({EXP_DIGITO})+.
IDENTIFICADOR_INVALIDO = {EXP_ALPHA_MAYUS} ({EXP_ALPHA}|{EXP_DIGITO})*
//fin declaraciones

/* Seccion de reglas lexicas */
%% 
//Regla     {Acciones}

{ENTERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_ENTERO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"IniciaPrograma"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"si"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"funcion"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"sino"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"ciclo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"entero"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"flotante"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"verdadero"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"falso"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"config"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"salidaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"entradaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"compuertaAbierta"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"compuertaCerrada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"comprimir"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarParada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"vaciarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"capacidadContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"estadoLinea"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"sobrecupo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"avanzar"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detener"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"estadoEnergia"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"modalidadSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"ENTRADA"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"SALIDA"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"ALTO"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ALTO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"vaciarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"soltarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"temporizador"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"mientras"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"vaciarCamion"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{ID}   {
    if(!eliminar){
        contador++;
        Yytoken t = new Yytoken(contador,yytext(),"ID",yyline+1,yycolumn,false);
        tokens.add(t);
        return t;
    }
    eliminar = false;
}

{FLOTANTE}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_FLOTANTE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{EXPONENTE} {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_EXPONENTE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{NUMERO_INVALIDO} {
    Yytoken t = new Yytoken(contador,"Error","Número no valido (falta numero antes o despues de < . >)",yyline+1,yycolumn,true);
    tokens.add(t);
    return t;
}

{IDENTIFICADOR_INVALIDO} {
    Yytoken t = new Yytoken(contador,"Error","Los identificadores no pueden iniciar con MAYUSCULAS < "+yytext()+" >",yyline+1,yycolumn,true);
    tokens.add(t);
    return t;
}

"=="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IGUAL_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ASIGNACION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"<"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MENOR_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

">"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MAYOR_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"<="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MENOR_IGUAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

">="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MAYOR_IGUAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"!="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DISTINTO_DE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"+"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SUMA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"-"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"RESTA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"*"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MULTIPLICACION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"/"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DIVISION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"++"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"INCREMENTO_UNO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"--"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DECREMENTO_UNO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"+="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SUMA_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"-="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"RESTA_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"*="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MULTIPLI_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

";" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PUNTO_COMA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"{" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LLAVE_ABRE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"}" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LLAVE_CIERRA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{CARAC_ESPECIAL}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"CARACTER_ESPECIAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"&&"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OP_LOG_AND",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"||"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OP_LOG_OR",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{ESPACIO} {
 	//ignorar
}

{SALTO} {
   //Ignorar
}
[^]   {if(Character.isUpperCase(yytext().charAt(0))){
                    Yytoken t = new Yytoken(0, "Error", "Los identificadores no pueden iniciar con mayuscula < "+ yytext()+" >", yyline+1, yycolumn, true);
                    tokens.add(t);
                    eliminar = true;
                    return t;
                }
                else
                {
                    Yytoken t = new Yytoken(0, yytext(), "Error: Simbolo no reconocido", yyline+1, yycolumn, true);
                    tokens.add(t);
                    return t;
                }} 
