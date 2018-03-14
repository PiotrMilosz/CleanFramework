package Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogStatuses {

	protected final static  Logger Log = LoggerFactory.getLogger(LogStatuses.class.getName());

    public synchronized static void startTestCase(String sTestCaseName) {

        Log.info("************************************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$       " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("************************************************************************************************************");
    }

    public synchronized static void endTestCase() {

        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXX               " + "-E---N---D-" + "               XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public synchronized static void info(String message) {

        Log.info(message);
    }

    public synchronized static void warn(String message) {

        Log.warn(message);
    }

    public synchronized static void error(String message) {

        Log.error(message);
    }

    public synchronized static void debug(String message) {

        Log.debug(message);
    }
}

