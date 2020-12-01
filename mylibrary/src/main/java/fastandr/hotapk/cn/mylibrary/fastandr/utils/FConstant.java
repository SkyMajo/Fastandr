package fastandr.hotapk.cn.mylibrary.fastandr.utils;

/**
 * @author laijian
 * @version 2017/11/24
 * @Copyright (C)下午10:04 , www.hotapk.cn
 * 一些常量
 */
public class FConstant {
    public static final String SHAREDPREFS_XML = "SHAREDPREFS_XML";
    public static final String INTEGER = "integer";
    public static final String BOOLEAN = "boolean";
    public static final String FLOAT = "float";
    public static final String LONG = "long";
    public static final String TEXT = "text";
    public static final String STRING_SET = "set";
    public static final String BLOB = "blob";
    public static final String REAL = "real";


    /**
     * 设备端数据库常量
     */
    public class DeviceDb {
        public transient static final String DEVICE_KEY = "device.db";
        public static final String USER = "user";
        public static final String DEVICELOG = "devicelog";
        public static final String USER_PERMISSIONS = "UserPermissions";
        public static final String WEEK_TIME_USER = "WeekTimeUser";
        public static final String ATT = "att";
        public static final String USER_ACCOUNT = "userAccount";
        public static final String USER_TOKEN = "userToken";
        public static final String PORTASTRICT = "portAstrict";
    }

    /**
     * databse columns name.
     */
    public class Key {
        public static final String USER_ID = "userId";
        public static final String USER_NAME = "userName";
        public static final String USER_DEPT_NAME = "userDeptName";
        public static final String USER_CODE = "userCode";
        public static final String USER_PHONE = "userPhone";
        public static final String OPEN_TYPE = "openType";
        public static final String WEEK_TYPE = "weekType";
        public static final String WEEK = "week";
        public static final String ATT_TIME = "attTime";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String TOKEN = "token";
        public static final String FILE = "file";
        public static final String ACCOUNT_ID = "accountId";
        public static final String PNG = "png";
        public static final String JPG = "jpg";
        public static final String USER_DELETE = "userDelete";
        public static final String ADMIN_FLAG = "adminFlag";
        public static final String LOG_ACCOUNT = "logAccount";
        public static final String LOG_CONTENT = "logContent";
        public static final String LOG_TIME = "logTime";
        public static final String LOG_ID = "logId";
        public static final String ATT_ID = "attId";
        public static final String ID = "id";
        public static final String UPLOAD_FLAG = "uploadFlag";
        public static final String INDEX = "index";
        public static final String PAGE_SIZE = "pageSize";
        public static final String USER_IMG = "userImg";
        public static final String USER_BASE64 = "userBase64";
        public static final String IMAG_BASE64 = "imagBase64";
        public static final String ATT_IMAG = "attImag";

        //必可拓
        public static final String BKT_PUSH_URL = "bktPushUrl";
        public static final String BKT_FACE_SUCCESS = "faceSuccess";
        public static final String BKT_FACE_FAIL = "faceFail";
        public static final String BKT_FACE_FEATURE = "faceFeature";
        public static final String FACE_MODE_SWITCH = "face_mode_switch";
        public static final String DEVICE_RS422 = "device_RS422";
    }

    public static final String DEFAULT_PASSWORD = "123456";
    public static final String DEFAULT_PERMISSION_VALIDITY_BEGIN_TIME = "2019-01-01";
    public static final String DEFAULT_PERMISSION_VALIDITY_END_TIME = "2119-01-01";


    public static final String IGNORE_URL = "user/feature,device/screen,face/check,face/update";

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    //上传文件大小限制为5M
    public static transient final int FILE_MAX_SIZE = 1024 * 1024 * 2;

    public static final String DB_URL = "device/db";
    public static final String SP_URL = "device/config";

}
