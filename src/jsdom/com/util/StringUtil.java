package jsdom.com.util;


import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class StringUtil {

    public static String encode(String s)
    {
        try
        {
            return new String(s.getBytes("KSC5601"), "8859_1");
        }
        catch(Exception exception)
        {
            return null;
        }
    } 

	public static String encode(String s, String enc) 
	{
        try {
            return new String(s.getBytes("KSC5601"), enc);
        } catch(Exception exception) {
            return null;
        }
    }

	public static String decode(String s)
    {
        try
        {
            return new String(s.getBytes("8859_1"), "EUC-KR");
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    public static String[] decode(String as[])
    {
        if(as == null)
            return null;
        for(int i = 0; i < as.length; i++)
            as[i] = decode(as[i]);

        return as;
    }

    public static boolean isDefined(String s)
    {
        return !"null".equals(s) && s != null && s.length() != 0;
    }

    public static boolean isDefined(String as[])
    {
        return as != null && as.length != 0;
    }

	public static String toUpperCase(String s) {
		if (!isDefined(s))
			return s;
		return s.toUpperCase();
	}
	
	public static String toLowerCase(String s) {
		if (!isDefined(s))
			return s;
		return s.toLowerCase();
	}
	
    public static String getNameByte(String s, int start, int end) throws Exception { 
    	int bytelen = getByte(s);
    	if (start == 0 && end > bytelen)
    		return s;
    	if (start < bytelen && (end < bytelen || end == bytelen)) {
    		return s.substring(start/2, end/2);
    	}
    	return "";
    }
    
    public static int getByte(String s)
    {
        int i = 1;
        if(s != null)
        {
            for(int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);
                if(isHalf(c))
                    i++;
                else
                    i += 2;
            }

        }
        return i;
    }
    
    private static boolean isHalf(char c)
    {
        return ' ' <= c && c < '\177';
    }

    public static String[] tokenize(String s, String s1)
    {
        if(s == null || s1 == null)
            return null;
        else
            return tokenize(new StringTokenizer(s, s1));
    }

    public static String[] tokenize(StringTokenizer stringtokenizer)
    {
        return tokenize(stringtokenizer, stringtokenizer.countTokens());
    }

    public static String[] tokenize(StringTokenizer stringtokenizer, int i)
    {
        String as[] = new String[i];
        for(int j = 0; j < i; j++)
            as[j] = stringtokenizer.hasMoreElements() ? stringtokenizer.nextToken().trim() : null;

        return as;
    }

    public static String toString(Collection c) {
		if (c == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for (Iterator i = c.iterator(); i.hasNext(); ) {
			sb.append(i.next());
			if (i.hasNext()) sb.append(", ");
		}
		return sb.toString();
	}
	
	public static String toString(Object object) { 
		if (object != null)
			return object.toString();
		return "";
	}
	
	public static String toString(int c) {
		return String.valueOf(c);
	}
	
	public static String toString(int[] c) {
		if (c == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
			if (i < c.length - 1) sb.append(", ");
		}
		return sb.toString();
	}
    
	public static String toString(double d) {
		return Double.toString(d);
	}

    public static String toString(String as[])
    {
        if(as == null)
            return "";
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < as.length; i++)
        {
            stringbuffer.append(as[i]);
            if(i < as.length - 1)
                stringbuffer.append(",");
        }

        return stringbuffer.toString();
    }

    public static String toString(List list, List list1)
    {
        if(list == null || list1 == null)
            return "";
        int i = list.size();
        int j = list1.size();
        if(i != j)
            return "";
        StringBuffer stringbuffer = new StringBuffer();
        for(int k = 0; k < i; k++)
        {
            stringbuffer.append(list.get(k)).append("=").append(list1.get(k));
            if(k < i - 1)
                stringbuffer.append(", ");
        }

        return stringbuffer.toString();
    }

	public static boolean contains(String s, String in) {
		if (!isDefined(s))
				return false;
		return s.indexOf(in) > -1 ? true : false;
	}

	public static boolean contains(String s, String[] in) {
		boolean flag = false;
		if (!isDefined(in))
			return false;
		for (int i=0; i<in.length; i++) {
			if (equals(s, in[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static boolean containsKorean(String s) { 
		if (s == null)
			return false;
		boolean b = false;
		for (int i=0; i<s.length(); i++) { 
			if (Character.getType(s.charAt(i)) == Character.OTHER_LETTER) {
				b = true;
				break;
			}
		}
		return b;
	}
	
    public static boolean equals(String s, String s1) {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equals(s1);
    }

    public static boolean equalsIgnoreCase(String s, String s1) {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(s1);
    }

    public static boolean equals(String s, Object s1) {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(toString(s1));
    }

    public static boolean equalsIgnoreCase(String s, Object s1) {
        if(s == null && toString(s1) == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(toString(s1));
    }

    public static boolean equals(int i, int j) {
        return i == j;
    }

    public static String trim(String s) { 
    	if (!isDefined(s))
    		return s;
    	return s.trim();
    }
    
    public static String[] trim(String[] s) { 
    	if (s == null)
    		return null;
    	String[] as = new String[s.length];
    	for (int i=0; i<s.length; i++) {
    		as[i] = trim(s[i]);
    	}
    	return as;
    }

    public static int parseInt(String s) {
        return parseInt(s, 0);
    }

    public static int parseInt(Object o) {
        return parseInt(o, 0);
    }

    public static int parseInt(String s, int i) {
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException numberformatexception)
        {
            return i;
        }
    }

    public static int parseInt(Object o, int i) {
        try
        {
            return Integer.parseInt(toString(o));
        }
        catch(NumberFormatException numberformatexception)
        {
            return i;
        }
    }
    
    public static String normalizeNull(String s) {
	    if(s == null)
	        return "";
	    if (equals(s, "null"))
	    	return "";
	    if (equals(s, "undefined"))
	    	return "";
	    return s;
	}

	public static String escape(int i) { 
		return escape(toString(i));
	}

	public static String escape(String s) { 
		if (!isDefined(s))
			return "";

        String s1 = s;
		s1 = s1.replaceAll("&", "&amp;");
		s1 = s1.replaceAll("\'", "&#039;");
		s1 = s1.replaceAll("\"", "&#34;");
		s1 = s1.replaceAll("<", "&lt;");
		s1 = s1.replaceAll(">", "&gt;");

		return s1;
	}

	public static String normalizeSql(int i) {
        return normalizeSql(toString(i));
    }

    public static String normalizeSql(String s) {
        if (!isDefined(s))
        	return "";
    	s = s.replaceAll("/", "//");
        s = s.replaceAll("%", "/%");
        s = s.replaceAll("_", "/_");
        return s;
    }

    public static String normalize(String s, String replace) {
		if (!isDefined(s))
			return normalizeNull(replace);
		return s;
	}
	
	public static String normalize(String s) {
        if(s == null)
            return "";
        
        int i;
        for(int j = -1; (i = s.substring(j + 1).indexOf('&')) != -1; j = i)
        {
            i += j + 1;
            s = new String((new StringBuffer(s)).replace(i, i + 1, "&amp;"));
        }

        return normalizeLtGtQuot(s);
    }

	public static String normalizeLtGtQuot(String s) {
        if(s == null)
            return "";
        for(int i = -1; (i = s.indexOf('"')) != -1;)
            s = new String((new StringBuffer(s)).replace(i, i + 1, "&quot;"));

        int j;
        while((j = s.indexOf('<')) != -1) 
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&lt;"));
        while((j = s.indexOf('>')) != -1) 
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&gt;"));
        while((j = s.indexOf('&')) != -1) 
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&amp;"));
        return s;
    }
	
    public static String replace(String s, String s1, String s2)
    {
        if(s == null || s1 == null || s2 == null)
            return s;
        StringBuffer stringbuffer = new StringBuffer();
        int i = s1.length();
        int j = 0;
        for(int k = 0; (k = s.indexOf(s1, j)) != -1;)
        {
            stringbuffer.append(s.substring(j, k)).append(s2);
            j = k + i;
        }

        stringbuffer.append(s.substring(j));
        return stringbuffer.toString();
    }

    public static String format(Timestamp timestamp, String format) { 
    	if (timestamp == null)
    		return "";
    	return new SimpleDateFormat(format).format(timestamp); 
    }
    
    public static String getFormatToday(String format) { 
    	java.util.Date today = new java.util.Date();
    	
    	return new SimpleDateFormat(format).format(new java.sql.Timestamp(today.getTime())); 
    }
    
    public static String format(String s) { 
       	if (s == null || s.length() < 14)
    		return "";
    	return s.substring(0,4) + "-" + s.substring(4,6) + "-" + s.substring(6,8) + " " + 
    		s.substring(8,10) + ":" + s.substring(10,12) + ":" + s.substring(12,14);
    }

    public static String formatToYYYYMMDD(String s) { 
    	if (s == null || s.length() < 8)
    		return s;
    	return s.substring(0,4) + "-" + s.substring(4,6) + "-" + s.substring(6,8);
    }
    public static String formateDateInline(String s) { 
    	if (s == null)
    		return s;
    	String[] list = tokenize(s, "-");
    	if (list != null && list.length > 0) { 
    		if (list.length > 2)
    	    	return "(" + list[0] + ")" + list[1] + "-" + list[2];
    		else if (list.length > 1)
    			return "";
    	}
    	return "";
    }
    
    public static String formatCurrency(String s) { 
    	if (!StringUtil.isDefined(s) || "null".equals(s))
    		return "";
    	
    	try { 
    	Double currency = new Double(s);
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	String currencyOut = currencyFormatter.format(currency);
    		return StringUtil.replace(currencyOut.toString(), "￦", "");
    	} catch (Exception e) { 
    		return s;
    	} 
    }
    
    public static String formatCurrencyComma(int i) { 
    	NumberFormat usFormat = 
    	      NumberFormat.getIntegerInstance(Locale.US);
    	return usFormat.format(i);
    }
    
    public static boolean isRangeDate(String d, int range) { 
    	Timestamp timestamp = new Timestamp(StringUtil.parseInt(d.substring(0,4)), StringUtil.parseInt(d.substring(4,6)), StringUtil.parseInt(d.substring(6,8)), 0, 0, 0, 0);
    	long after = timestamp.getTime()+(1000*60*60*24) * range;
    	long today = Calendar.getInstance().getTimeInMillis();
    	
    	return today <= after;
    }
    
    public static String fill(String s, String fill, int max) { 
    	if (s == null) 
    		return "";
    	int len = s.length();
    	for (int i=0; i < max - len; i++) { 
    		s = fill + s;
    	}
    	return s;
    }
    
    public static String cut(String s, int max) { 
    	if (s == null)
    		return "";
    	if (s.length() > max)
    		return s.substring(0, max) + "...";
    	return s;
    }
    
    public static String cutString(String s, int len, String tail) {
    	if (s == null || s.equals("")) {
            return "";
    	}
    	String rs = "";
    	try {
	        int srcLen = s.getBytes("utf-8").length;
	        if (srcLen < len){
	            return s;
	        }
	        String tmpTail = tail;
	        if (tail == null){
	            tmpTail = "";
	        }
	        int tailLen = tmpTail.getBytes("utf-8").length;
	        if (tailLen > len){
	            return "";
	        }
	        char a;
	        int i = 0;
	        int realLen = 0;
	        for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
	           a = s.charAt(i);
	           if ((a & 0xFF00) == 0){
	               realLen += 1;
	           }else{
	               realLen += 3;
	           }
	        }
	        while ((s.substring(0, i).getBytes("utf-8").length) > len - tailLen) {
	            i--;
	        }
	        rs = s.substring(0, i) + tmpTail;
    	} catch (Exception e) {
			e.printStackTrace(System.out);
		}
    	return rs;
    }

    
    
    public static String URL_encode(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("KSC5601");
        }
        catch(Exception exception)
        {
            return "";
        }
        for(int i = 0; i < abyte0.length; i++)
            switch(abyte0[i])
            {
            case 32: // ' '
                stringbuffer.append("+");
                break;

            case 33: // '!'
                stringbuffer.append("%21");
                break;

            case 35: // '#'
                stringbuffer.append("%23");
                break;

            case 36: // '$'
                stringbuffer.append("%24");
                break;

            case 37: // '%'
                stringbuffer.append("%25");
                break;

            case 94: // '^'
                stringbuffer.append("%5E");
                break;

            case 38: // '&'
                stringbuffer.append("%26");
                break;

            case 40: // '('
                stringbuffer.append("%28");
                break;

            case 41: // ')'
                stringbuffer.append("%29");
                break;

            case 61: // '='
                stringbuffer.append("%3D");
                break;

            case 43: // '+'
                stringbuffer.append("%2B");
                break;

            case 91: // '['
                stringbuffer.append("%5B");
                break;

            case 93: // ']'
                stringbuffer.append("%5D");
                break;

            case 123: // '{'
                stringbuffer.append("%7B");
                break;

            case 125: // '}'
                stringbuffer.append("%7D");
                break;

            case 124: // '|'
                stringbuffer.append("%7C");
                break;

            case 92: // '\\'
                stringbuffer.append("%5C");
                break;

            case 58: // ':'
                stringbuffer.append("%3A");
                break;

            case 59: // ';'
                stringbuffer.append("%3B");
                break;

            case 34: // '"'
                stringbuffer.append("%22");
                break;

            case 39: // '\''
                stringbuffer.append("%27");
                break;

            case 60: // '<'
                stringbuffer.append("%3C");
                break;

            case 62: // '>'
                stringbuffer.append("%3E");
                break;

            case 44: // ','
                stringbuffer.append("%2C");
                break;

            case 63: // '?'
                stringbuffer.append("%3F");
                break;

            case 47: // '/'
                stringbuffer.append("%2F");
                break;

            case 126: // '~'
                stringbuffer.append("%7E");
                break;

            case 96: // '`'
                stringbuffer.append("%60");
                break;

            case 42: // '*'
            case 45: // '-'
            case 46: // '.'
            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
            case 64: // '@'
            case 65: // 'A'
            case 66: // 'B'
            case 67: // 'C'
            case 68: // 'D'
            case 69: // 'E'
            case 70: // 'F'
            case 71: // 'G'
            case 72: // 'H'
            case 73: // 'I'
            case 74: // 'J'
            case 75: // 'K'
            case 76: // 'L'
            case 77: // 'M'
            case 78: // 'N'
            case 79: // 'O'
            case 80: // 'P'
            case 81: // 'Q'
            case 82: // 'R'
            case 83: // 'S'
            case 84: // 'T'
            case 85: // 'U'
            case 86: // 'V'
            case 87: // 'W'
            case 88: // 'X'
            case 89: // 'Y'
            case 90: // 'Z'
            case 95: // '_'
            case 97: // 'a'
            case 98: // 'b'
            case 99: // 'c'
            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
            case 106: // 'j'
            case 107: // 'k'
            case 108: // 'l'
            case 109: // 'm'
            case 110: // 'n'
            case 111: // 'o'
            case 112: // 'p'
            case 113: // 'q'
            case 114: // 'r'
            case 115: // 's'
            case 116: // 't'
            case 117: // 'u'
            case 118: // 'v'
            case 119: // 'w'
            case 120: // 'x'
            case 121: // 'y'
            case 122: // 'z'
            default:
                if((abyte0[i] & 0x80) == 128)
                    stringbuffer.append("%" + Integer.toHexString(abyte0[i] & 0xff));
                else
                    stringbuffer.append((char)abyte0[i]);
                break;
            }

        return stringbuffer.toString();
    }

	public static String normalizeXml(int i) { 
		return normalizeXml(toString(i));
	}
	
	public static String normalizeXml(long i) { 
		return normalizeXml(toString(i));
	}
	
	public static String normalizeXml(String s) { 
		if (!isDefined(s))
			return "";
		String s1 = replace(s, "&", "&amp;");
		s1 = s1.replaceAll("&", "&amp;");
		s1 = s1.replaceAll("\'", "&#039;");
		s1 = s1.replaceAll("\"", "&#34;");
		s1 = s1.replaceAll("<", "&lt;");
		s1 = s1.replaceAll(">", "&gt;");
		return s1;
	}
    
}
