package br.com.pedrodcp.nizybot.managers;

public class TimeManager {

    protected static String keyAno;
    protected static String keyMes;
    protected static String keyDias;
    protected static String keyHoras;
    protected static String keyMinutos;
    protected static String keySegundos;

    public static String getTime(long time) {
        long variacao = time;
        long varsegundos = variacao / 1000L % 60L;
        long varminutos = variacao / 60000L % 60L;
        long varhoras = variacao / 3600000L % 24L;
        long vardias = variacao / 86400000L % 7L;
        long varmeses = variacao / 2628000000L % 12L;
        long varanos = variacao / 31536000000L % 365L;

        String segundos = String.valueOf(varsegundos).replaceAll("-", "");
        String minutos = String.valueOf(varminutos).replaceAll("-", "");
        String horas = String.valueOf(varhoras).replaceAll("-", "");
        String dias = String.valueOf(vardias).replaceAll("-", "");
        String meses = String.valueOf(varmeses).replaceAll("-", "");
        String anos = String.valueOf(varanos).replaceAll("-", "");

        //
        if (anos.equals("1")) {
            keyAno = anos + " ano, ";
        } else {
            if (anos.equals("0")) {
                keyAno = "";
            } else {
                keyAno = anos + " anos, ";
            }
        }
        //
        if (meses.equals("12")) {
            keyMes = "";
        } else {
            if (meses.equals("1")) {
                keyMes = meses + " mês, ";
            } else {
                if (meses.equals("0")) {
                    keyMes = "";
                } else {
                    keyMes = meses + " meses, ";
                }
            }
        }
        //
        if (dias.equals("1")) {
            keyDias = dias + " dia, ";
        } else {
            if (dias.equals("0")) {
                keyDias = "";
            } else {
                keyDias = dias + " dias, ";
            }
        }
        //
        if (horas.equals("1")) {
            keyHoras = horas + " hora, ";
        } else {
            if (horas.equals("0")) {
                keyHoras = "";
            } else {
                keyHoras = horas + " horas, ";
            }
        }
        //
        if (minutos.equals("1")) {
            keyMinutos = minutos + " minuto e ";
        } else {
            if (minutos.equals("0")) {
                keyMinutos = "";
            } else {
                keyMinutos = minutos + " minutos e ";
            }
        }
        //
        if (segundos.equals("1")) {
            keySegundos = segundos + " segundo";
        } else {
            if (segundos.equals("0")) {
                keySegundos = "";
            } else {
                keySegundos = segundos + " segundos";
            }
        }
        //

        if (anos.equals("0") && meses.equals("0") && dias.equals("0") && horas.equals("0") && minutos.equals("0")) {
            return "" + keySegundos;
        }
        if (anos.equals("0") && meses.equals("0") && dias.equals("0") && horas.equals("0")) {
            return "" + keyMinutos + keySegundos;
        }
        if (anos.equals("0") && meses.equals("0") && dias.equals("0")) {
            return "" + keyHoras + keyMinutos + keySegundos;
        }
        if (anos.equals("0") && meses.equals("0")) {
            return "" + keyDias + keyHoras + keyMinutos + keySegundos;
        }
        if (anos.equals("0")) {
            return "" + keyMes + keyDias + keyHoras + keyMinutos + keySegundos;
        }
        return "" + keyAno + keyMes + keyDias + keyHoras + keyMinutos + keySegundos;
    }

}
