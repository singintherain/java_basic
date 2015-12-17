package lvsong.club;


import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class RmtShellExecutor
{
    private String hostIp;
    private String userName;
    private String password;
    private String port;

    private Connection connection;
    private String charSet = Charset.defaultCharset().toString();

    private static final int TIME_OUT = 1000 * 50 * 60;

    public RmtShellExecutor(String hostIp, String userName, String password, String port){
        this.hostIp = hostIp;
        this.userName = userName;
        this.password = password;
        this.port = port;
    }

    private boolean login() throws IOException{
        connection = new Connection(hostIp, Integer.valueOf(port));
        connection.connect();
        return connection.authenticateWithPassword(userName, password);
    }

    public int execute(String command) throws Exception{
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        String outErr = "";
        int ret = -1;

        try{
            if(login()){
                Session session = connection.openSession();
                session.execCommand(command);

                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charSet);
                System.out.println(outStr);
                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charSet);
                System.out.println(outErr);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

                ret = session.getExitStatus();
            }else{
                throw new Exception("login error on "+hostIp+ "server");
            }
        }finally{
            if(connection != null){
                connection.close();
            }
        }

        return ret;
    }

    /**
     * 返回shell输出结果
     * @param command
     * @return
     * @throws Exception
     */
    public String executeWithResult(String command) throws Exception{
        InputStream stdOut = null;
//		InputStream stdErr = null;
        String outStr = "";
//		String outErr = "";
//		int ret = -1;

        try{
            if(login()){
                Session session = connection.openSession();
                session.execCommand(command);

                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charSet);
//				System.out.println(outStr);
//				stdErr = new StreamGobbler(session.getStderr());
//				outErr = processStream(stdErr, charSet);
//			    System.out.println(outErr);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

                session.getExitStatus();
            }else{
                throw new Exception("login error on "+hostIp+ "server");
            }
        }finally{
            if(connection != null){
                connection.close();
            }
        }

        return outStr;
    }

    private String processStream(InputStream in, String charset) throws Exception{
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while(in.read(buf) != -1){
            sb.append(new String(buf, charset));
        }
        return sb.toString();
    }
}
