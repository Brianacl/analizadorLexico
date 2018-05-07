/* The following code was generated by JFlex 1.6.1 */

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

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/lex/alexico.flex</tt>
 */
public class AnalizadorLexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\15\1\6\1\10\1\10\1\7\22\0\1\13\1\56\1\0"+
    "\1\14\1\0\1\14\1\65\1\14\2\0\1\60\1\57\1\14\1\1"+
    "\1\14\1\61\12\5\1\0\1\62\1\54\1\53\1\55\2\14\1\41"+
    "\1\3\1\43\1\37\1\11\3\3\1\16\2\3\1\44\1\3\1\47"+
    "\1\52\1\23\1\3\1\51\1\46\1\50\6\3\4\0\1\4\1\0"+
    "\1\22\1\42\1\21\1\36\1\12\1\31\1\26\1\2\1\20\2\2"+
    "\1\33\1\27\1\17\1\25\1\40\1\2\1\24\1\30\1\34\1\32"+
    "\1\35\3\2\1\45\1\63\1\66\1\64\7\0\1\10\71\0\1\14"+
    "\41\0\1\4\7\0\1\4\3\0\1\4\5\0\1\4\6\0\1\4"+
    "\u1f2d\0\1\10\1\10\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\6\1\1"+
    "\1\4\1\3\1\7\1\10\1\6\1\4\10\3\2\4"+
    "\1\11\1\12\1\13\1\10\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\10\1\1\1\22\1\23\1\5\1\24"+
    "\1\4\3\22\1\4\2\3\1\4\6\3\1\25\11\3"+
    "\2\4\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\2\0\1\37\1\0\1\4\2\3\1\4"+
    "\22\3\2\4\1\0\1\40\1\4\3\3\1\4\6\3"+
    "\1\25\11\3\1\41\1\4\1\3\1\4\21\3\1\4"+
    "\1\3\1\4\17\3\1\25\2\3\1\4\16\3\1\4"+
    "\12\3\1\4\10\3\1\4\7\3\1\4\5\3\1\4"+
    "\3\3\1\4\2\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[225];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\67\0\156\0\245\0\334\0\u0113\0\u014a\0\u0181"+
    "\0\u014a\0\u01b8\0\u01ef\0\67\0\67\0\67\0\u0226\0\u025d"+
    "\0\u0294\0\u02cb\0\u0302\0\u0339\0\u0370\0\u03a7\0\u03de\0\u0415"+
    "\0\u044c\0\u0483\0\u04ba\0\u04f1\0\u0528\0\u055f\0\u0596\0\67"+
    "\0\67\0\67\0\67\0\u05cd\0\u0604\0\67\0\u014a\0\u063b"+
    "\0\u014a\0\u0672\0\334\0\u06a9\0\u06e0\0\u0717\0\u074e\0\u0785"+
    "\0\u07bc\0\u07f3\0\u082a\0\u0861\0\u0898\0\u08cf\0\u0906\0\u093d"+
    "\0\u0974\0\u09ab\0\u09e2\0\u0a19\0\u0a50\0\u0a87\0\u0abe\0\u0af5"+
    "\0\u0b2c\0\u0b63\0\u0b9a\0\u014a\0\u014a\0\u014a\0\u014a\0\u014a"+
    "\0\u014a\0\u014a\0\u014a\0\u014a\0\u06a9\0\u06e0\0\u0bd1\0\u0c08"+
    "\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52\0\u0d89\0\u0dc0"+
    "\0\u0df7\0\u0e2e\0\u0e65\0\u0e9c\0\u0ed3\0\u0f0a\0\u0f41\0\u0f78"+
    "\0\u0faf\0\u0fe6\0\u101d\0\u1054\0\u108b\0\u10c2\0\u10f9\0\u1130"+
    "\0\u1167\0\u0c08\0\u119e\0\u11d5\0\u120c\0\u1243\0\u127a\0\u12b1"+
    "\0\u12e8\0\u131f\0\u1356\0\u138d\0\u13c4\0\245\0\u13fb\0\u1432"+
    "\0\u1469\0\u14a0\0\u14d7\0\u150e\0\u1545\0\u157c\0\u15b3\0\u0672"+
    "\0\u15ea\0\u1621\0\u1658\0\u168f\0\u16c6\0\u16fd\0\u1734\0\u176b"+
    "\0\u17a2\0\u17d9\0\u1810\0\u1847\0\u187e\0\u18b5\0\u18ec\0\u1923"+
    "\0\u195a\0\u1991\0\u19c8\0\u19ff\0\u1a36\0\u1a6d\0\u1aa4\0\u1adb"+
    "\0\u1b12\0\u1b49\0\u1b80\0\u1bb7\0\u1bee\0\u1c25\0\u1c5c\0\u1c93"+
    "\0\u1cca\0\u1d01\0\u1d38\0\u1d6f\0\u1da6\0\u1ddd\0\u0672\0\u1e14"+
    "\0\u1e4b\0\u1e82\0\u1eb9\0\u1ef0\0\u1f27\0\u1f5e\0\u1f95\0\u1fcc"+
    "\0\u2003\0\u203a\0\u2071\0\u20a8\0\u20df\0\u2116\0\u214d\0\u2184"+
    "\0\u21bb\0\u21f2\0\u2229\0\u2260\0\u2297\0\u22ce\0\u2305\0\u233c"+
    "\0\u2373\0\u23aa\0\u23e1\0\u2418\0\u244f\0\u2486\0\u24bd\0\u24f4"+
    "\0\u252b\0\u2562\0\u2599\0\u25d0\0\u2607\0\u263e\0\u2675\0\u26ac"+
    "\0\u26e3\0\u271a\0\u2751\0\u2788\0\u27bf\0\u27f6\0\u282d\0\u2864"+
    "\0\u289b\0\u28d2\0\u2909\0\u2940\0\u2977\0\u29ae\0\u29e5\0\u2a1c"+
    "\0\u2a53";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[225];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\2\4"+
    "\1\20\1\21\1\5\3\4\1\22\1\23\1\24\2\4"+
    "\1\25\1\26\1\27\1\5\1\4\1\30\1\4\2\5"+
    "\1\4\1\31\4\5\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\5\0"+
    "\1\46\62\0\1\47\3\0\1\50\45\0\1\51\15\0"+
    "\4\4\3\0\2\4\3\0\35\4\16\0\3\52\1\53"+
    "\3\0\2\52\3\0\35\52\14\0\5\54\1\6\3\0"+
    "\2\55\54\54\75\0\1\7\62\0\3\52\1\53\3\0"+
    "\2\52\3\0\31\52\1\56\3\52\16\0\4\4\3\0"+
    "\2\4\3\0\1\4\1\57\10\4\1\60\22\4\16\0"+
    "\3\52\1\53\3\0\2\52\3\0\1\52\1\61\33\52"+
    "\16\0\4\4\3\0\2\4\3\0\2\4\1\62\1\4"+
    "\1\63\2\4\1\64\25\4\16\0\4\4\3\0\2\4"+
    "\3\0\17\4\1\65\15\4\16\0\4\4\3\0\2\4"+
    "\3\0\2\4\1\66\4\4\1\67\25\4\16\0\4\4"+
    "\3\0\2\4\3\0\2\4\1\70\1\4\1\71\2\4"+
    "\1\72\25\4\16\0\4\4\3\0\2\4\3\0\4\4"+
    "\1\73\7\4\1\74\1\75\17\4\16\0\4\4\3\0"+
    "\1\4\1\76\3\0\35\4\16\0\4\4\3\0\1\4"+
    "\1\77\3\0\4\4\1\100\30\4\16\0\4\4\3\0"+
    "\1\4\1\101\3\0\35\4\16\0\3\52\1\53\3\0"+
    "\2\52\3\0\26\52\1\102\6\52\16\0\3\52\1\53"+
    "\3\0\2\52\3\0\23\52\1\103\11\52\21\0\1\46"+
    "\45\0\1\104\20\0\1\46\45\0\1\105\20\0\1\46"+
    "\45\0\1\106\20\0\1\46\45\0\1\107\20\0\1\50"+
    "\45\0\1\110\3\0\1\111\14\0\1\46\45\0\1\112"+
    "\20\0\1\46\57\0\1\113\6\0\1\46\60\0\1\114"+
    "\5\115\1\50\3\0\2\116\54\115\2\0\4\52\3\0"+
    "\2\52\3\0\35\52\21\0\1\117\62\0\1\120\3\0"+
    "\1\117\51\0\1\120\11\0\4\52\3\0\2\52\3\0"+
    "\32\52\1\121\2\52\16\0\4\4\3\0\2\4\3\0"+
    "\16\4\1\122\16\4\16\0\4\4\3\0\2\4\3\0"+
    "\16\4\1\123\16\4\16\0\4\52\3\0\2\52\3\0"+
    "\2\52\1\124\32\52\16\0\4\4\3\0\2\4\3\0"+
    "\3\4\1\125\31\4\16\0\4\4\3\0\2\4\3\0"+
    "\22\4\1\126\12\4\16\0\4\4\3\0\2\4\3\0"+
    "\1\4\1\127\7\4\1\130\23\4\16\0\4\4\3\0"+
    "\2\4\3\0\4\4\1\131\30\4\16\0\4\4\3\0"+
    "\1\4\1\132\3\0\35\4\16\0\4\4\3\0\2\4"+
    "\3\0\20\4\1\133\14\4\16\0\4\4\3\0\2\4"+
    "\3\0\1\4\1\134\33\4\16\0\4\4\3\0\2\4"+
    "\3\0\15\4\1\135\17\4\16\0\4\4\3\0\2\4"+
    "\3\0\15\4\1\136\6\4\1\137\10\4\16\0\4\4"+
    "\3\0\2\4\3\0\15\4\1\140\17\4\16\0\4\4"+
    "\3\0\2\4\3\0\1\4\1\141\33\4\16\0\4\4"+
    "\3\0\2\4\3\0\7\4\1\142\25\4\16\0\4\4"+
    "\3\0\2\4\3\0\11\4\1\143\23\4\16\0\4\4"+
    "\3\0\2\4\3\0\6\4\1\144\26\4\16\0\4\4"+
    "\3\0\2\4\3\0\3\4\1\145\31\4\16\0\4\4"+
    "\3\0\2\4\3\0\16\4\1\146\16\4\16\0\4\52"+
    "\3\0\2\52\3\0\32\52\1\147\2\52\16\0\4\52"+
    "\3\0\2\52\3\0\26\52\1\150\6\52\21\0\1\117"+
    "\3\0\2\151\61\0\1\152\63\0\4\52\3\0\2\52"+
    "\3\0\33\52\1\153\1\52\16\0\4\4\3\0\1\4"+
    "\1\154\3\0\6\4\1\155\26\4\16\0\4\4\3\0"+
    "\2\4\3\0\4\4\1\156\30\4\16\0\4\52\3\0"+
    "\2\52\3\0\3\52\1\157\31\52\16\0\4\4\3\0"+
    "\2\4\3\0\15\4\1\134\17\4\16\0\4\4\3\0"+
    "\2\4\3\0\4\4\1\160\30\4\16\0\4\4\3\0"+
    "\2\4\3\0\13\4\1\161\21\4\16\0\4\4\3\0"+
    "\2\4\3\0\22\4\1\162\12\4\16\0\4\4\3\0"+
    "\2\4\3\0\1\4\1\163\33\4\16\0\4\4\3\0"+
    "\2\4\3\0\1\4\1\164\33\4\16\0\4\4\3\0"+
    "\2\4\3\0\4\4\1\165\30\4\16\0\4\4\3\0"+
    "\2\4\3\0\7\4\1\166\25\4\16\0\4\4\3\0"+
    "\2\4\3\0\2\4\1\167\32\4\16\0\4\4\3\0"+
    "\2\4\3\0\16\4\1\170\16\4\16\0\4\4\3\0"+
    "\2\4\3\0\6\4\1\171\26\4\16\0\4\4\3\0"+
    "\2\4\3\0\12\4\1\134\22\4\16\0\4\4\3\0"+
    "\2\4\3\0\3\4\1\172\31\4\16\0\4\4\3\0"+
    "\2\4\3\0\16\4\1\173\16\4\16\0\4\4\3\0"+
    "\2\4\3\0\22\4\1\174\12\4\16\0\4\4\3\0"+
    "\2\4\3\0\20\4\1\175\14\4\16\0\4\4\3\0"+
    "\2\4\3\0\2\4\1\176\32\4\16\0\4\4\3\0"+
    "\1\4\1\177\3\0\35\4\16\0\4\52\3\0\2\52"+
    "\3\0\34\52\1\200\16\0\4\52\3\0\2\52\3\0"+
    "\1\201\34\52\15\0\1\120\3\0\1\152\51\0\1\120"+
    "\11\0\4\52\3\0\2\52\3\0\23\52\1\201\11\52"+
    "\16\0\4\4\3\0\2\4\3\0\6\4\1\134\26\4"+
    "\16\0\4\4\3\0\2\4\3\0\4\4\1\167\30\4"+
    "\16\0\4\4\3\0\2\4\3\0\20\4\1\202\14\4"+
    "\16\0\4\52\3\0\2\52\3\0\2\52\1\203\32\52"+
    "\16\0\4\4\3\0\2\4\3\0\3\4\1\204\31\4"+
    "\16\0\4\4\3\0\2\4\3\0\2\4\1\205\32\4"+
    "\16\0\4\4\3\0\2\4\3\0\6\4\1\206\5\4"+
    "\1\207\20\4\16\0\4\4\3\0\2\4\3\0\27\4"+
    "\1\210\5\4\16\0\4\4\3\0\2\4\3\0\16\4"+
    "\1\211\16\4\16\0\4\4\3\0\2\4\3\0\15\4"+
    "\1\212\17\4\16\0\4\4\3\0\2\4\3\0\20\4"+
    "\1\213\14\4\16\0\4\4\3\0\2\4\3\0\4\4"+
    "\1\214\30\4\16\0\4\4\3\0\1\4\1\215\3\0"+
    "\35\4\16\0\4\4\3\0\2\4\3\0\2\4\1\216"+
    "\32\4\16\0\4\4\3\0\2\4\3\0\4\4\1\217"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\7\4\1\220"+
    "\25\4\16\0\4\4\3\0\2\4\3\0\4\4\1\221"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\4\4\1\222"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\1\4\1\223"+
    "\1\4\1\224\31\4\16\0\4\52\3\0\2\52\3\0"+
    "\21\52\1\225\13\52\16\0\4\4\3\0\2\4\3\0"+
    "\7\4\1\226\25\4\16\0\4\52\3\0\2\52\3\0"+
    "\4\52\1\227\30\52\16\0\4\4\3\0\2\4\3\0"+
    "\2\4\1\230\32\4\16\0\4\4\3\0\2\4\3\0"+
    "\10\4\1\166\24\4\16\0\4\4\3\0\2\4\3\0"+
    "\2\4\1\231\32\4\16\0\4\4\3\0\1\4\1\232"+
    "\3\0\35\4\16\0\4\4\3\0\2\4\3\0\4\4"+
    "\1\233\30\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\234\26\4\16\0\4\4\3\0\2\4\3\0\2\4"+
    "\1\235\32\4\16\0\4\4\3\0\2\4\3\0\4\4"+
    "\1\236\30\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\237\26\4\16\0\4\4\3\0\2\4\3\0\3\4"+
    "\1\240\31\4\16\0\4\4\3\0\2\4\3\0\7\4"+
    "\1\241\25\4\16\0\4\4\3\0\2\4\3\0\1\4"+
    "\1\242\33\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\243\26\4\16\0\4\4\3\0\2\4\3\0\20\4"+
    "\1\244\14\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\245\26\4\16\0\4\4\3\0\1\4\1\233\3\0"+
    "\35\4\16\0\4\4\3\0\2\4\3\0\16\4\1\246"+
    "\16\4\16\0\4\52\3\0\2\52\3\0\23\52\1\247"+
    "\11\52\16\0\4\4\3\0\1\250\1\4\3\0\26\4"+
    "\1\251\6\4\16\0\4\52\3\0\2\52\3\0\5\52"+
    "\1\252\27\52\16\0\4\4\3\0\2\4\3\0\20\4"+
    "\1\253\14\4\16\0\4\4\3\0\2\4\3\0\11\4"+
    "\1\254\23\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\255\26\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\166\26\4\16\0\4\4\3\0\2\4\3\0\4\4"+
    "\1\256\30\4\16\0\4\4\3\0\2\4\3\0\20\4"+
    "\1\257\14\4\16\0\4\4\3\0\2\4\3\0\21\4"+
    "\1\260\13\4\16\0\4\4\3\0\2\4\3\0\25\4"+
    "\1\261\7\4\16\0\4\4\3\0\2\4\3\0\14\4"+
    "\1\262\20\4\16\0\4\4\3\0\2\4\3\0\1\4"+
    "\1\166\33\4\16\0\4\4\3\0\2\4\3\0\16\4"+
    "\1\263\16\4\16\0\4\4\3\0\2\4\3\0\2\4"+
    "\1\264\32\4\16\0\4\4\3\0\1\4\1\154\3\0"+
    "\35\4\16\0\4\4\3\0\2\4\3\0\25\4\1\265"+
    "\7\4\16\0\4\4\3\0\2\4\3\0\4\4\1\266"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\1\4\1\267"+
    "\33\4\16\0\4\4\3\0\2\4\3\0\2\4\1\270"+
    "\32\4\16\0\4\52\3\0\2\52\3\0\6\52\1\271"+
    "\26\52\16\0\4\4\3\0\2\4\3\0\4\4\1\272"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\2\4\1\233"+
    "\32\4\16\0\4\4\3\0\2\4\3\0\16\4\1\273"+
    "\16\4\16\0\4\4\3\0\2\4\3\0\12\4\1\166"+
    "\22\4\16\0\4\4\3\0\2\4\3\0\4\4\1\274"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\4\4\1\275"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\7\4\1\276"+
    "\25\4\16\0\4\4\3\0\2\4\3\0\22\4\1\134"+
    "\12\4\16\0\4\4\3\0\1\4\1\166\3\0\35\4"+
    "\16\0\4\4\3\0\2\4\3\0\27\4\1\277\5\4"+
    "\16\0\4\4\3\0\2\4\3\0\4\4\1\300\2\4"+
    "\1\276\25\4\16\0\4\4\3\0\2\4\3\0\6\4"+
    "\1\301\26\4\16\0\4\4\3\0\1\4\1\302\3\0"+
    "\35\4\16\0\4\4\3\0\2\4\3\0\1\4\1\303"+
    "\33\4\16\0\4\52\3\0\2\52\3\0\7\52\1\304"+
    "\25\52\16\0\4\4\3\0\2\4\3\0\20\4\1\237"+
    "\14\4\16\0\4\4\3\0\2\4\3\0\4\4\1\305"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\20\4\1\306"+
    "\14\4\16\0\4\4\3\0\2\4\3\0\16\4\1\134"+
    "\16\4\16\0\4\4\3\0\2\4\3\0\1\4\1\307"+
    "\33\4\16\0\4\4\3\0\2\4\3\0\4\4\1\310"+
    "\30\4\16\0\4\4\3\0\2\4\3\0\11\4\1\172"+
    "\23\4\16\0\4\4\3\0\2\4\3\0\5\4\1\311"+
    "\17\4\1\261\2\4\1\312\4\4\16\0\4\4\3\0"+
    "\2\4\3\0\6\4\1\313\26\4\16\0\4\4\3\0"+
    "\1\4\1\314\3\0\35\4\16\0\4\52\3\0\2\52"+
    "\3\0\10\52\1\315\24\52\16\0\4\4\3\0\2\4"+
    "\3\0\23\4\1\316\1\4\1\317\7\4\16\0\4\4"+
    "\3\0\2\4\3\0\30\4\1\312\4\4\16\0\4\4"+
    "\3\0\2\4\3\0\16\4\1\320\16\4\16\0\4\4"+
    "\3\0\2\4\3\0\20\4\1\321\14\4\16\0\4\4"+
    "\3\0\2\4\3\0\4\4\1\322\30\4\16\0\4\4"+
    "\3\0\1\4\1\323\3\0\35\4\16\0\4\4\3\0"+
    "\2\4\3\0\10\4\1\324\24\4\16\0\4\4\3\0"+
    "\2\4\3\0\4\4\1\166\30\4\16\0\4\52\3\0"+
    "\2\52\3\0\6\52\1\325\26\52\16\0\4\4\3\0"+
    "\2\4\3\0\24\4\1\326\10\4\16\0\4\4\3\0"+
    "\1\4\1\327\3\0\35\4\16\0\4\4\3\0\1\4"+
    "\1\330\3\0\35\4\16\0\4\4\3\0\2\4\3\0"+
    "\7\4\1\233\25\4\16\0\4\4\3\0\2\4\3\0"+
    "\6\4\1\331\26\4\16\0\4\4\3\0\2\4\3\0"+
    "\1\4\1\332\33\4\16\0\4\4\3\0\2\4\3\0"+
    "\2\4\1\314\32\4\16\0\4\52\3\0\2\52\3\0"+
    "\4\52\1\333\30\52\16\0\4\4\3\0\2\4\3\0"+
    "\2\4\1\334\32\4\16\0\4\4\3\0\2\4\3\0"+
    "\6\4\1\322\26\4\16\0\4\4\3\0\2\4\3\0"+
    "\1\4\1\335\33\4\16\0\4\4\3\0\2\4\3\0"+
    "\4\4\1\336\30\4\16\0\4\4\3\0\2\4\3\0"+
    "\12\4\1\321\22\4\16\0\4\52\3\0\2\52\3\0"+
    "\11\52\1\337\23\52\16\0\4\4\3\0\1\4\1\340"+
    "\3\0\35\4\16\0\4\4\3\0\1\4\1\310\3\0"+
    "\35\4\16\0\4\4\3\0\2\4\3\0\20\4\1\314"+
    "\14\4\16\0\4\52\3\0\2\52\3\0\4\52\1\247"+
    "\30\52\16\0\4\4\3\0\2\4\3\0\6\4\1\341"+
    "\26\4\16\0\4\4\3\0\2\4\3\0\16\4\1\314"+
    "\16\4\14\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10890];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\5\1\1\11\1\1\1\11\35\1\1\11\1\1"+
    "\1\11\32\1\11\11\2\0\1\1\1\0\30\1\1\0"+
    "\170\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[225];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */

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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
      contador = 0;
    tokens = new ArrayList<Yytoken>();
    eliminar = false;
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 220) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    	try{
		this.writeOutputFile();
        //System.exit(0);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Yytoken nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { if(Character.isUpperCase(yytext().charAt(0))){
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
                }
            }
          case 34: break;
          case 2: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"RESTA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 35: break;
          case 3: 
            { if(!eliminar){
        contador++;
        Yytoken t = new Yytoken(contador,yytext(),"ID",yyline+1,yycolumn,false);
        tokens.add(t);
        return t;
    }
    eliminar = false;
            }
          case 36: break;
          case 4: 
            { Yytoken t = new Yytoken(contador,"Error","Los identificadores no pueden iniciar con MAYUSCULAS < "+yytext()+" >",yyline+1,yycolumn,true);
    tokens.add(t);
    return t;
            }
          case 37: break;
          case 5: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_ENTERO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 38: break;
          case 6: 
            { //Ignorar
            }
          case 39: break;
          case 7: 
            { //ignorar
            }
          case 40: break;
          case 8: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"CARACTER_ESPECIAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 41: break;
          case 9: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ASIGNACION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 42: break;
          case 10: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MENOR_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 43: break;
          case 11: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MAYOR_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 44: break;
          case 12: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SUMA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 45: break;
          case 13: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MULTIPLICACION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 46: break;
          case 14: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DIVISION",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 47: break;
          case 15: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PUNTO_COMA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 48: break;
          case 16: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LLAVE_ABRE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 49: break;
          case 17: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LLAVE_CIERRA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 50: break;
          case 18: 
            { Yytoken t = new Yytoken(contador,"Error","Número no valido (falta numero antes o despues de < . >)",yyline+1,yycolumn,true);
    tokens.add(t);
    return t;
            }
          case 51: break;
          case 19: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DECREMENTO_UNO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 52: break;
          case 20: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"RESTA_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 53: break;
          case 21: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 54: break;
          case 22: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IGUAL_QUE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 55: break;
          case 23: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MENOR_IGUAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 56: break;
          case 24: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MAYOR_IGUAL",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 57: break;
          case 25: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"DISTINTO_DE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 58: break;
          case 26: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"SUMA_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 59: break;
          case 27: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"INCREMENTO_UNO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 60: break;
          case 28: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"MULTIPLI_ASIGNA",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 61: break;
          case 29: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OP_LOG_AND",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 62: break;
          case 30: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OP_LOG_OR",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 63: break;
          case 31: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_FLOTANTE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 64: break;
          case 32: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"NUM_EXPONENTE",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 65: break;
          case 33: 
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"ALTO",yyline+1,yycolumn,false);
    tokens.add(t);
    return t;
            }
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
