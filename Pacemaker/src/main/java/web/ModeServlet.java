package web;

import com.fazecast.jSerialComm.SerialPort;
import pojo.Mode;
import pojo.User;
import service.ModeService;
import service.impl.ModeServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModeServlet extends BaseServlet {

    static ModeService modeService = new ModeServiceImpl();

    protected void storeMode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Mode mode = new Mode();
        mode.setLRL(WebUtils.findNumStr(req.getParameter("Lower Rate Limit")));
        mode.setURL(WebUtils.findNumStr(req.getParameter("Upper Rate Limit")));
        mode.setAA(WebUtils.findNumStr(req.getParameter("Atrial Amplitude")));
        mode.setVA(WebUtils.findNumStr(req.getParameter("Ventricular Amplitude")));
        mode.setAPW(WebUtils.findNumStr(req.getParameter("Atrial Pulse Width")));
        mode.setVPW(WebUtils.findNumStr(req.getParameter("Ventricular Pulse Width")));
        mode.setVRP(WebUtils.findNumStr(req.getParameter("VRP")));
        mode.setARP(WebUtils.findNumStr(req.getParameter("ARP")));
        mode.setMSR(WebUtils.findNumStr(req.getParameter("Maximum Sensor Rate")));
        mode.setFAD(WebUtils.findNumStr(req.getParameter("Fixed AV Delay")));
        mode.setAS(WebUtils.findNumStr(req.getParameter("Atrial Sensitivity")));
        mode.setVS(WebUtils.findNumStr(req.getParameter("Ventricular Sensitivity")));
        mode.setPVARP(WebUtils.findNumStr(req.getParameter("PVARP")));
        mode.setAT(WebUtils.findNumStr(req.getParameter("Activity Threshold")));
        mode.setRT(WebUtils.findNumStr(req.getParameter("Reaction Time")));
        mode.setRF(WebUtils.findNumStr(req.getParameter("Response Factor")));
        mode.setRecT(WebUtils.findNumStr(req.getParameter("Recovery Time")));
        mode.setMode(req.getParameter("mode"));
        User user = (User) req.getSession().getAttribute("user");
        mode.setId(user.getId());
        req.getSession().setAttribute("mode", mode);
        System.out.println(mode);
        modeService.openPort();
        modeService.transmitModeParameter(mode,modeService.getPort());
        req.getRequestDispatcher("/pages/mode/setMode_success.jsp").forward(req, resp);
    }

    protected void getPlot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modeService.getPort().getSystemPortName();
        modeService.getPlot(modeService.getPort());
        req.getRequestDispatcher("/pages/mode/setMode_success.jsp").forward(req, resp);
    }

    protected void getEcho(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modeService.openPort();
        modeService.getEcho(modeService.getPort());
        req.getRequestDispatcher("/pages/mode/setMode_success.jsp").forward(req, resp);
    }

    protected void stopReceiveData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modeService.openPort();
        modeService.stopReceivingData(modeService.getPort());
        req.getRequestDispatcher("/pages/mode/setMode_success.jsp").forward(req, resp);
    }
}
