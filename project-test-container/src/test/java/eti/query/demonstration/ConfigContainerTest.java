package eti.query.demonstration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.nio.file.Paths;

public abstract class ConfigContainerTest {


    private static final Logger LOGGER = ConfigContainerTest.createLogger();

    private static Network network = Network.newNetwork();

    private static ImageFromDockerfile getImageForOracle() {
        String dockerFile = System.getProperty("user.dir").concat("/src/config/oracle/Dockerfile");
        ImageFromDockerfile imageFromDockerfile =
                new ImageFromDockerfile("oracle-18c-xe-hr").withDockerfile(Paths.get(dockerFile));
        return imageFromDockerfile;
    }

    private static ImageFromDockerfile getImageForPrjectMainPayara() {
        String dockerFile = System.getProperty("user.dir").concat("/src/config/payara/Dockerfile");
        ImageFromDockerfile imageFromDockerfile =
                new ImageFromDockerfile("payara-project-main").withDockerfile(Paths.get(dockerFile));
        return imageFromDockerfile;
    }

    private static String getOracleVolume() {
        String volume = System.getProperty("user.dir").concat("/containers_data/db/oracle-18c-xe-HR");
        return volume;
    }

    private static GenericContainer oracleGC = new GenericContainer<>(getImageForOracle())
        .withFileSystemBind(getOracleVolume(), "/opt/oracle/oradata")
        .withExposedPorts(1521)
        .withPrivilegedMode(true)
        .withNetwork(network)
        .withNetworkAliases("oracledatabase")
        .withLogConsumer(new Slf4jLogConsumer(LOGGER))
        .waitingFor(Wait.forLogMessage(".*DATABASE IS READY TO USE!.*", 1));

    private static GenericContainer payaraGC = new GenericContainer<>(getImageForPrjectMainPayara())
        .withExposedPorts(8080)
        .withNetwork(network)
        .withNetworkAliases("payara")
        .withLogConsumer(new Slf4jLogConsumer(LOGGER))
        .waitingFor(Wait.forHttp("/demo/application.wadl"));
    ;

    /**
     * Create custom logger at Runtime
     *
     * @return
     */
    private static Logger createLogger() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setPattern("%msg%n");
        ple.setContext(lc);
        ple.start();

        ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<>();
        consoleAppender.setEncoder(ple);
        consoleAppender.setContext(lc);
        consoleAppender.start();

        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ConfigContainerTest.class);

        logger.addAppender(consoleAppender);
        logger.setAdditive(false);
        return logger;
    }

    protected String getAppServerURLBase() {
        return String.format("http://%s:%s", payaraGC.getContainerIpAddress(), payaraGC.getFirstMappedPort());
    }

    @BeforeClass
    public static void before() throws Exception {

        oracleGC.start();

        payaraGC.start();
    }

    @AfterClass
    public static void after() throws Exception {
        payaraGC.stop();

        oracleGC.stop();
    }
}