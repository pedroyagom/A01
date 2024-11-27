import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfiguracoesSistema {
    public static final String VERSAO_SISTEMA = "12.1.2024";
    public static final String NOME_USUARIO = "denys.silva";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm");
    public static final String DATA_ACESSO = DATE_FORMAT.format(new Date());

    // Método sobrecarregado: Retorna a data de acesso no formato padrão
    public static String obterDataAcesso() {
        return DATA_ACESSO;
    }

    // Método sobrecarregado: Retorna a data de acesso em um formato específico
    public static String obterDataAcesso(String formato) {
        DateFormat customFormat = new SimpleDateFormat(formato);
        return customFormat.format(new Date());
    }

    // Método sobrecarregado: Retorna uma configuração específica
    public static String obterConfiguracao(String chave) {
        switch (chave.toLowerCase()) {
            case "versao":
                return VERSAO_SISTEMA;
            case "usuario":
                return NOME_USUARIO;
            case "data_acesso":
                return DATA_ACESSO;
            default:
                return "Configuração não encontrada";
        }
    }
}
