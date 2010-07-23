package service;

import org.apache.click.service.ConsoleLogService;

public class Logger extends ConsoleLogService {

    private Logger() {}

    private static class LoggerHolder { private static Logger getLoggerForUsage = new Logger();}

    public static Logger getInstance() { return LoggerHolder.getLoggerForUsage; }

}