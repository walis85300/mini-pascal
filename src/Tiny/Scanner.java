/* The following code was generated by JFlex 1.4.1 on 08/05/16 05:22 PM */

package Tiny;

import java_cup.runtime.*;
//import otros.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 08/05/16 05:22 PM from the specification file
 * <tt>lexico.flex</tt>
 */
class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  3,  0,  0,  4,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     5,  0,  0,  0,  0,  0,  0,  0, 39, 40, 37, 35, 44, 36, 45, 38, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 31, 43, 33, 32, 34,  0, 
     0, 28, 27,  2,  2,  2,  2,  2,  2, 26,  2,  2,  2,  2,  2,  2, 
    15,  2,  2,  2,  2,  2, 12,  2,  2,  2,  2, 41,  0, 42,  0,  0, 
     0, 13,  6, 30, 22,  7, 11,  8, 19,  9,  2,  2, 20, 17, 10, 16, 
    23,  2, 14, 21, 18, 25,  2, 24,  2, 29,  2, 46,  0, 47,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\21\3"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\1"+
    "\1\4\3\3\1\25\6\3\1\26\1\27\1\30\1\3"+
    "\1\31\7\3\1\32\1\33\1\34\1\35\1\0\1\3"+
    "\1\36\1\3\1\37\1\3\1\40\1\41\14\3\1\42"+
    "\1\3\1\43\1\3\1\44\3\3\1\45\7\3\1\46"+
    "\5\3\1\47\1\50\1\51\2\3\1\52\1\3\1\53"+
    "\1\54\5\3\1\55\1\3\1\56\1\57\1\60\1\3"+
    "\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[130];
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
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0"+
    "\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420\0\u0450"+
    "\0\u0480\0\60\0\u04b0\0\u04e0\0\60\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\60\0\60\0\u0510"+
    "\0\60\0\u0540\0\u0570\0\u05a0\0\220\0\u05d0\0\u0600\0\u0630"+
    "\0\u0660\0\u0690\0\u06c0\0\220\0\220\0\220\0\u06f0\0\220"+
    "\0\u0720\0\u0750\0\u0780\0\u07b0\0\u07e0\0\u0810\0\u0840\0\60"+
    "\0\60\0\60\0\60\0\u0870\0\u08a0\0\220\0\u08d0\0\220"+
    "\0\u0900\0\220\0\220\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0"+
    "\0\u0a20\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0b40\0\60"+
    "\0\u0b70\0\220\0\u0ba0\0\220\0\u0bd0\0\u0c00\0\u0c30\0\220"+
    "\0\u0c60\0\u0c90\0\u0cc0\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\220"+
    "\0\u0db0\0\u0de0\0\u0e10\0\u0e40\0\u0e70\0\220\0\220\0\220"+
    "\0\u0ea0\0\u0ed0\0\220\0\u0f00\0\220\0\220\0\u0f30\0\u0f60"+
    "\0\u0f90\0\u0fc0\0\u0ff0\0\220\0\u1020\0\220\0\220\0\220"+
    "\0\u1050\0\220";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[130];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\4\1\12\1\4\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\4\1\21\3\4\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\2\4\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\2\61\0\1\3\60\0"+
    "\1\4\3\0\31\4\25\0\1\51\56\0\1\51\61\0"+
    "\1\7\54\0\1\4\3\0\1\4\1\52\27\4\23\0"+
    "\1\4\3\0\4\4\1\53\11\4\1\54\12\4\23\0"+
    "\1\4\3\0\5\4\1\55\23\4\23\0\1\4\3\0"+
    "\12\4\1\56\10\4\1\57\5\4\23\0\1\4\3\0"+
    "\7\4\1\60\21\4\23\0\1\4\3\0\4\4\1\61"+
    "\24\4\23\0\1\4\3\0\1\4\1\62\27\4\23\0"+
    "\1\4\3\0\10\4\1\63\20\4\23\0\1\4\3\0"+
    "\5\4\1\64\2\4\1\65\20\4\23\0\1\4\3\0"+
    "\12\4\1\66\2\4\1\67\13\4\23\0\1\4\3\0"+
    "\12\4\1\70\16\4\23\0\1\4\3\0\10\4\1\71"+
    "\20\4\23\0\1\4\3\0\10\4\1\72\4\4\1\73"+
    "\13\4\23\0\1\4\3\0\4\4\1\74\24\4\23\0"+
    "\1\4\3\0\4\4\1\75\24\4\23\0\1\4\3\0"+
    "\12\4\1\76\16\4\23\0\1\4\3\0\10\4\1\77"+
    "\20\4\61\0\1\100\57\0\1\101\1\0\1\102\55\0"+
    "\1\103\17\0\57\104\3\0\1\4\3\0\2\4\1\105"+
    "\26\4\23\0\1\4\3\0\20\4\1\106\10\4\23\0"+
    "\1\4\3\0\17\4\1\107\11\4\23\0\1\4\3\0"+
    "\10\4\1\110\20\4\23\0\1\4\3\0\4\4\1\111"+
    "\24\4\23\0\1\4\3\0\10\4\1\112\20\4\23\0"+
    "\1\4\3\0\20\4\1\113\10\4\23\0\1\4\3\0"+
    "\7\4\1\114\4\4\1\115\4\4\1\116\7\4\23\0"+
    "\1\4\3\0\12\4\1\117\16\4\23\0\1\4\3\0"+
    "\1\4\1\120\27\4\23\0\1\4\3\0\12\4\1\121"+
    "\16\4\23\0\1\4\3\0\3\4\1\122\25\4\23\0"+
    "\1\4\3\0\3\4\1\123\25\4\23\0\1\4\3\0"+
    "\14\4\1\124\14\4\23\0\1\4\3\0\14\4\1\125"+
    "\14\4\23\0\1\4\3\0\12\4\1\126\16\4\23\0"+
    "\1\4\3\0\10\4\1\127\20\4\21\0\57\104\1\130"+
    "\2\0\1\4\3\0\3\4\1\131\25\4\23\0\1\4"+
    "\3\0\1\4\1\132\27\4\23\0\1\4\3\0\30\4"+
    "\1\133\23\0\1\4\3\0\20\4\1\134\10\4\23\0"+
    "\1\4\3\0\23\4\1\135\5\4\23\0\1\4\3\0"+
    "\1\4\1\136\27\4\23\0\1\4\3\0\2\4\1\137"+
    "\26\4\23\0\1\4\3\0\4\4\1\140\24\4\23\0"+
    "\1\4\3\0\30\4\1\141\23\0\1\4\3\0\14\4"+
    "\1\142\14\4\23\0\1\4\3\0\16\4\1\143\12\4"+
    "\23\0\1\4\3\0\3\4\1\144\25\4\23\0\1\4"+
    "\3\0\1\4\1\145\27\4\23\0\1\4\3\0\16\4"+
    "\1\146\12\4\23\0\1\4\3\0\7\4\1\147\21\4"+
    "\23\0\1\4\3\0\4\4\1\150\24\4\23\0\1\4"+
    "\3\0\14\4\1\151\14\4\23\0\1\4\3\0\10\4"+
    "\1\152\20\4\23\0\1\4\3\0\7\4\1\153\21\4"+
    "\23\0\1\4\3\0\10\4\1\154\20\4\23\0\1\4"+
    "\3\0\1\4\1\155\27\4\23\0\1\4\3\0\1\4"+
    "\1\156\27\4\23\0\1\4\3\0\1\4\1\157\27\4"+
    "\23\0\1\4\3\0\16\4\1\160\12\4\23\0\1\4"+
    "\3\0\2\4\1\161\26\4\23\0\1\4\3\0\1\4"+
    "\1\162\27\4\23\0\1\4\3\0\27\4\1\163\1\4"+
    "\23\0\1\4\3\0\3\4\1\164\25\4\23\0\1\4"+
    "\3\0\4\4\1\165\24\4\23\0\1\4\3\0\14\4"+
    "\1\166\14\4\23\0\1\4\3\0\7\4\1\167\21\4"+
    "\23\0\1\4\3\0\20\4\1\170\10\4\23\0\1\4"+
    "\3\0\1\4\1\171\27\4\23\0\1\4\3\0\7\4"+
    "\1\172\21\4\23\0\1\4\3\0\12\4\1\173\16\4"+
    "\23\0\1\4\3\0\13\4\1\174\15\4\23\0\1\4"+
    "\3\0\23\4\1\175\5\4\23\0\1\4\3\0\10\4"+
    "\1\176\20\4\23\0\1\4\3\0\4\4\1\177\24\4"+
    "\23\0\1\4\3\0\4\4\1\200\24\4\23\0\1\4"+
    "\3\0\10\4\1\201\20\4\23\0\1\4\3\0\1\4"+
    "\1\202\27\4\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4224];
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
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\27\1\1\11\2\1\13\11\1\1\1\11"+
    "\26\1\4\11\1\0\23\1\1\11\52\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[130];
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

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

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

  /* user code: */
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		lineanum=0;
		debug=true;
	}
	private SymbolFactory sf;
	private int lineanum;
	private boolean debug;


/******************************************************************
BORRAR SI NO SE NECESITA
	//TODO: Cambiar la SF por esto o ver que se hace
	//Crear un nuevo objeto java_cup.runtime.Symbol con informaci???n sobre el token actual sin valor
 	  private Symbol symbol(int type){
    		return new Symbol(type,yyline,yycolumn);
	  }
	//Crear un nuevo objeto java_cup.runtime.Symbol con informaci???n sobre el token actual con valor
	  private Symbol symbol(int type,Object value){
    		return new Symbol(type,yyline,yycolumn,value);
	  }
******************************************************************/


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
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
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
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
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
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
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
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
          yycolumn++;
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
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 45: 
          { if(debug) System.out.println("token PROGRAM");
			return sf.newSymbol("PROGRAM", sym.PROGRAM);
          }
        case 50: break;
        case 9: 
          { if(debug) System.out.println("token GT");
			return sf.newSymbol("GT", sym.GT);
          }
        case 51: break;
        case 6: 
          { if (debug) System.out.println("token COL");
			return sf.newSymbol("COL", sym.COL);
          }
        case 52: break;
        case 3: 
          { if(debug) System.out.println("token ID");
				return sf.newSymbol("ID",sym.ID,new String(yytext()));
          }
        case 53: break;
        case 42: 
          { if (debug) System.out.println("token ARRAY");
			return sf.newSymbol("ARRAY", sym.ARRAY);
          }
        case 54: break;
        case 22: 
          { if (debug) System.out.println("token OF");
			return sf.newSymbol("OF", sym.OF);
          }
        case 55: break;
        case 41: 
          { if(debug) System.out.println("token UNTIL");
			return sf.newSymbol("UNTIL",sym.UNTIL);
          }
        case 56: break;
        case 47: 
          { if (debug) System.out.println("token BOOLEAN");
			return sf.newSymbol("BOOLEAN", sym.BOOLEAN);
          }
        case 57: break;
        case 13: 
          { if(debug) System.out.println("token OVER");
			return sf.newSymbol("OVER",sym.OVER);
          }
        case 58: break;
        case 11: 
          { if(debug) System.out.println("token MINUS");
			return sf.newSymbol("MINUS",sym.MINUS);
          }
        case 59: break;
        case 48: 
          { if (debug) System.out.println("token FUNCTION");
			return sf.newSymbol("FUNCTION", sym.FUNCTION);
          }
        case 60: break;
        case 16: 
          { if (debug) System.out.println("token LB");
			return sf.newSymbol("LB", sym.LB);
          }
        case 61: break;
        case 5: 
          { /* saltos espacios en blanco*/
          }
        case 62: break;
        case 26: 
          { if(debug) System.out.println("token ASSIGN");
			return sf.newSymbol("ASSIGN",sym.ASSIGN);
          }
        case 63: break;
        case 7: 
          { if(debug) System.out.println("token EQ");
			return sf.newSymbol("EQ",sym.EQ);
          }
        case 64: break;
        case 21: 
          { if(debug) System.out.println("token IF");
			return sf.newSymbol("IF",sym.IF);
          }
        case 65: break;
        case 29: 
          { if(debug) System.out.println("token GQ");
			return sf.newSymbol("GQ", sym.GQ);
          }
        case 66: break;
        case 18: 
          { if(debug) System.out.println("token SEMI");
			return sf.newSymbol("SEMI",sym.SEMI);
          }
        case 67: break;
        case 38: 
          { if(debug) System.out.println("token BEGIN");
			return sf.newSymbol("BEGIN", sym.BEGIN);
          }
        case 68: break;
        case 15: 
          { if(debug) System.out.println("token RPAREN");
			return sf.newSymbol("RPAREN",sym.RPAREN);
          }
        case 69: break;
        case 39: 
          { if(debug) System.out.println("token WRITE");
			return sf.newSymbol("WRITE",sym.WRITE);
          }
        case 70: break;
        case 24: 
          { if (debug) System.out.println("token TO");
			return sf.newSymbol("TO", sym.TO);
          }
        case 71: break;
        case 1: 
          { System.err.println("Caracter Ilegal encontrado en analisis lexico: " + yytext() + "\n");
          }
        case 72: break;
        case 44: 
          { if(debug) System.out.println("token REPEAT");
			return sf.newSymbol("REPEAT",sym.REPEAT);
          }
        case 73: break;
        case 27: 
          { if(debug) System.out.println("token LQ");
			return sf.newSymbol("LQ", sym.LQ);
          }
        case 74: break;
        case 37: 
          { if(debug) System.out.println("token THEN");
			return sf.newSymbol("THEN",sym.THEN);
          }
        case 75: break;
        case 25: 
          { if (debug) System.out.println("token DO");
			return sf.newSymbol("DO", sym.DO);
          }
        case 76: break;
        case 23: 
          { if(debug) System.out.println("token OR");
			return sf.newSymbol("OR", sym.OR);
          }
        case 77: break;
        case 34: 
          { /* salto comentarios */ if(debug) System.out.println("token COMENTARIO");
          }
        case 78: break;
        case 10: 
          { if(debug) System.out.println("token PLUS");
			return sf.newSymbol("PLUS",sym.PLUS);
          }
        case 79: break;
        case 46: 
          { if (debug) System.out.println("token INTEGER");
			return sf.newSymbol("INTEGER", sym.INTEGER);
          }
        case 80: break;
        case 43: 
          { if (debug) System.out.println("token RETURN");
			return sf.newSymbol("RETURN", sym.RETURN);
          }
        case 81: break;
        case 14: 
          { if(debug) System.out.println("token LPAREN");
			return sf.newSymbol("LPAREN",sym.LPAREN);
          }
        case 82: break;
        case 28: 
          { if(debug) System.out.println("token NQ");
			return sf.newSymbol("NQ", sym.NQ);
          }
        case 83: break;
        case 20: 
          { if (debug) System.out.println("token DOT");
			return sf.newSymbol("DOT", sym.DOT);
          }
        case 84: break;
        case 19: 
          { if (debug) System.out.println("token COMMA");
			return sf.newSymbol("COMMA", sym.COMMA);
          }
        case 85: break;
        case 35: 
          { if(debug) System.out.println("token ELSE");
			return sf.newSymbol("ELSE",sym.ELSE);
          }
        case 86: break;
        case 49: 
          { if (debug) System.out.println("token PROCEDURE");
			return sf.newSymbol("PROCEDURE", sym.PROCEDURE);
          }
        case 87: break;
        case 30: 
          { if(debug) System.out.println("token END");
			return sf.newSymbol("END",sym.END);
          }
        case 88: break;
        case 32: 
          { if(debug) System.out.println("token VAR");
			return sf.newSymbol("VAR", sym.VAR);
          }
        case 89: break;
        case 40: 
          { if(debug) System.out.println("token WHILE");
			return sf.newSymbol("WHILE",sym.WHILE);
          }
        case 90: break;
        case 36: 
          { if(debug) System.out.println("token READ");
			return sf.newSymbol("READ",sym.READ);
          }
        case 91: break;
        case 2: 
          { if(debug) System.out.println("token NUM");
			return sf.newSymbol("NUM",sym.NUM,new String(yytext()));
          }
        case 92: break;
        case 4: 
          { lineanum++;
          }
        case 93: break;
        case 31: 
          { if(debug) System.out.println("token FOR");
			return sf.newSymbol("FOR", sym.FOR);
          }
        case 94: break;
        case 8: 
          { if(debug) System.out.println("token LT");
			return sf.newSymbol("LT",sym.LT);
          }
        case 95: break;
        case 33: 
          { if(debug) System.out.println("token AND");
			return sf.newSymbol("AND", sym.AND);
          }
        case 96: break;
        case 12: 
          { if(debug) System.out.println("token TIMES");
			return sf.newSymbol("TIMES",sym.TIMES);
          }
        case 97: break;
        case 17: 
          { if (debug) System.out.println("token RB");
			return sf.newSymbol("RB", sym.RB);
          }
        case 98: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return sf.newSymbol("EOF",sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
