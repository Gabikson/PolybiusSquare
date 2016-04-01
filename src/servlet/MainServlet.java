package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import Calculation.MainCalculator;

@WebServlet("/Main")
public class MainServlet extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    JSONObject result = new JSONObject();
    if(req.getParameter("mode") != null && req.getParameter("mode").equals("coding")){
      try {
        result.append("result", MainCalculator.codeString(req.getParameter("data")));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    } else if(req.getParameter("mode") != null && req.getParameter("mode").equals("decoding")){
      try {
        result.append("result", MainCalculator.decodeString(req.getParameter("data")));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    resp.getWriter().write(result.toString());
  }

}
