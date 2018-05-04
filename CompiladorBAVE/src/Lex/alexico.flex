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
    //Metodo que devuelve los datos necesarios que escribiremos en un archive de salida
    public String toString() {
        if(error){
            return tipo+" < "+token+" > | [Linea: "+linea+", columna: " +columna + "]";
        }
        return "Token #"+numToken+": "+token+" | Componente léxico: "+tipo+" [Linea: "+linea+", columna: " +columna + "]";
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
SIGNO = [+-]
EXP_ALPHA_MINUS=[a-z]
EXP_ALPHA=[A-Za-z_]
EXP_DIGITO=[0-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
ENTERO={SIGNO}({EXP_DIGITO})+ | ({EXP_DIGITO})+
FLOTANTE ={SIGNO}({EXP_DIGITO})+.({EXP_DIGITO})+ | ({EXP_DIGITO})+.({EXP_DIGITO})+ 
EXPONENTE = {FLOTANTE}(E|e){ENTERO} | {ENTERO}(E|e){ENTERO}
IDENTIFICADOR={EXP_ALPHA_MINUS}({EXP_ALPHANUMERIC})*
ESPACIO=" "
CARAC_ESPECIAL=[@!%&#¿?',.]
SALTO=\n|\r|\r\n|\t
//fin declaraciones

/* Seccion de reglas lexicas */
%% 
//Regla     {Acciones}

{ENTERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"num_entero",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{FLOTANTE}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"num_flotante",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{EXPONENTE} {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"num_exponente",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"IniciaPrograma"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IniciaPrograma",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"si"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"si",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"funcion"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"funcion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"sino"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"sino",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"ciclo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ciclo",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"entero"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"entero",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"flotante"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"flotante",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"verdadero"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"verdadero",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"falso"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"falso",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"config"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"config",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"salidaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"salidaDato",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"entradaDato"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"entradaDato",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"compuertaAbierta"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"compuertaAbierta",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"compuertaCerrada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"compuertaCerrada",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"comprimir"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"comprimir",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarParada"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarParada",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarAnomalia",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"vaciarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"vaciarContenedor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"capacidadContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"capacidadContenedor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"estadoLinea"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"estadoLinea",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"sobrecupo"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"sobrecupo",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"avanzar"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"avanzar",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detener"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detener",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"estadoEnergia"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"estadoEnergia",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"detectarSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"detectarSensor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"modalidadSensor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"modalidadSensor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"ENTRADA"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ENTRADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"SALIDA"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SALIDA",yyline+1,yycolumn,false);
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
    Yytoken t = new Yytoken(contador,yytext(),"vaciarContenedor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"soltarContenedor"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"soltarContenedor",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"temporizador"    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"temporizador",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"mientras"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mientras",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"vaciarCamion"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"vaciarCamion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{IDENTIFICADOR}   {
    if(!eliminar){
                contador++;
                Yytoken t = new Yytoken(contador,yytext(),"id",yyline+1,yycolumn,false);
                tokens.add(t);
                return t;
                }
                eliminar = false;
}

"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asignacion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"=="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"comparacion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asignacion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"<"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"menor_que",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

">"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mayor_que",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"<="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"menor_igual",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

">="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"mayor_igual",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"!="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"diferente_de",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"+"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"suma",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"-"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"resta",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"*"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"multiplicacion",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"/"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"division",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"++"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"incremento",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"--"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"decremento",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"+="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"suma_asigna",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"-="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"resta_asigna",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"*="   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"multipli_asinga",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

";" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"punto_coma",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"{" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"llave_abre",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"}" {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"llave_cierra",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

{CARAC_ESPECIAL}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"caracter_especial",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"&&"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"operador_logico_and",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"||"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"operador_logico_or",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
}

"!"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"operador_logico_not",yyline+1,yycolumn,false);
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
                    Yytoken t = new Yytoken(0, yytext(), "Error: Los identificadores no pueden iniciar con mayuscula", yyline+1, yycolumn, true);
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
