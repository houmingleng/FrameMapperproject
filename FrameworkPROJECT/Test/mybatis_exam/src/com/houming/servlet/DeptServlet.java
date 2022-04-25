package com.houming.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.houming.pojo.Emp;
import com.houming.service.DeptService;
import com.houming.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/dept")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DeptService deptService=null;
	
	@Override
	public void init() throws ServletException {
		deptService= new DeptServiceImpl();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			switch (request.getParameter("op")) {
			case "depts":
				request.setAttribute("depts", deptService.getAllDept());
				request.getRequestDispatcher("/WEB-INF/dept/list.jsp").forward(request, response);
				return;
			case "emps":
				String id = request.getParameter("id");
				request.setAttribute("dept", deptService.getDept(id));
				request.setAttribute("emps", deptService.getEmpByDeptId(id));
				request.getRequestDispatcher("/WEB-INF/emp/list.jsp").forward(request, response);
				return;
			case "emp":
				id = request.getParameter("id");
				request.setAttribute("emp", deptService.getEmp(id));
				request.getRequestDispatcher("/WEB-INF/emp/info.jsp").forward(request, response);
				return;
			case "delemp":
				id = request.getParameter("id");
				String eid = request.getParameter("eid");
				request.setAttribute("result", deptService.delEmp(eid).get("message"));
				request.setAttribute("dept", deptService.getDept(id));
				request.setAttribute("emps", deptService.getEmpByDeptId(id));
				request.getRequestDispatcher("/WEB-INF/emp/list.jsp").forward(request, response);
				return;
			case "addemp":
				request.setAttribute("deptId", request.getParameter("id"));
				request.getRequestDispatcher("/WEB-INF/emp/add.jsp").forward(request, response);
				return;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			switch (request.getParameter("op")) {
			case "addemp":
				Emp emp = new Emp();
				emp.setAddress(request.getParameter("address"));
				emp.setDeptId(request.getParameter("deptId"));
				emp.setEage(request.getParameter("eage"));
				emp.setEgender(request.getParameter("egender"));
				emp.setEname(request.getParameter("ename"));
				emp.setPost(request.getParameter("post"));
				emp.setTel(request.getParameter("tel"));
				Map<String, Object> map = deptService.addEmp(emp);
				if(200==Integer.parseInt(map.get("code").toString())){
					request.setAttribute("dept", deptService.getDept(emp.getDeptId()));
					request.setAttribute("emps", deptService.getEmpByDeptId(emp.getDeptId()));
					request.getRequestDispatcher("/WEB-INF/emp/list.jsp").forward(request, response);
				}else{
					request.setAttribute("result", map.get("message"));
					request.setAttribute("deptId", emp.getDeptId());
					request.getRequestDispatcher("/WEB-INF/emp/add.jsp").forward(request, response);
				}
				return;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
