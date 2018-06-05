
package guru.springframework.converters;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;

/**
 * Constant Variables
 *
 * @author Kent
 */
public interface Global {

    /**
     * Constant variables for web return views
     */
    final static View JSON_VIEW = new MappingJackson2JsonView();

    /**
     * Constant variables for web return data labels
     */
    final static String REPORT_PATH = "report_path";
    final static String WEB_DATA_LABEL = "data";
    final static String WEB_DRAW_LABEL = "draw";
    final static String WEB_RECORD_TOTAL_LABEL = "recordsTotal";
    final static String WEB_RECORD_FILTERED_LABEL = "recordsFiltered";
    final static String WEB_ERROR_LABEL = "errorMessage";

    /**
     * Date format for DateUtils to parseDate
     * e.g. DateUtils.parseDate("12/12/2012", Global.dateFormat[0])
     */
    final static String[] dateFormat = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};

    final static String JSON_DATE_FORMAT = "dd/MM/yyyy";
    final static String OUTLET_DATE_FORMAT = "ddMMyy";

    final static String ACTIVE = "ACTIVE";

    final static int VARCHAR4000 = 4000;
    final static int VARCHAR2000 = 2000;
    final static int VARCHAR255 = 255;
    final static int VARCHAR128 = 128;
    final static int VARCHAR100 = 100;
    final static int VARCHAR64 = 64;
    final static int VARCHAR50 = 50;
    final static int VARCHAR32 = 32;
    final static int VARCHAR30 = 30;
    final static int VARCHAR20 = 20;
    final static int VARCHAR16 = 16;
    final static int VARCHAR15 = 15;
    final static int VARCHAR12 = 12;
    final static int VARCHAR10 = 10;
    final static int VARCHAR8 = 8;
    final static int VARCHAR6 = 6;
    final static int VARCHAR5 = 5;
    final static int VARCHAR4 = 4;
    final static int VARCHAR3 = 3;
    final static int VARCHAR2 = 2;

    final static String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+]).{8,20})";
    final static int LOGIN_ATTEMPTS = 5;

    final static String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";

    final static String usernameParams = "j_username";
    final static String passwordParams = "j_password";

    SimpleDateFormat DF_ddMMyyyyHHSS = new SimpleDateFormat("ddMMyyyyHHSS");
    SimpleDateFormat DF_ddMMyyyyHHmmss = new SimpleDateFormat("ddMMyyyyHHmmss");
    SimpleDateFormat DF_ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat DF_MMyyyy = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat DF_ddMMMMyyyy = new SimpleDateFormat("dd MMMM yyyy");

    final static String $_PATTERN_MATCHER = "[$]+[\\w]+\\b";
    final static String PDF_CONTENT_TYPE = "application/pdf";
    final static String PDF_FILE_EXT = ".pdf";

    final static String PDF_FILE_FORMAT = "pdf";
    final static String DOC_FILE_FORMAT = "doc";
    final static String DOCX_FILE_FORMAT = "docx";
    final static String XLS_FILE_FORMAT = "xls";
    final static String XLSX_FILE_FORMAT = "xlsx";
    final static String JPEG_FILE_FORMAT = "jpeg";
    final static String JPG_FILE_FORMAT = "jpg";
    final static String PNG_FILE_FORMAT = "png";
    final static String DOT = ".";
    final static int ONE = 1;
    final static int TWO = 2;

    String AVAILABILITY = "AVAILABILITY";
    String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";
    String DEFAULT_APP_ID = "XXX";

    String NEXT_REFERENCE_NUM = "NEXT_REFERENCE_NUM";

    String CREATED_UPDATED_BY = "SYSTEM";
    String MAX_SEQUENCE_VALUE = "999";

}

