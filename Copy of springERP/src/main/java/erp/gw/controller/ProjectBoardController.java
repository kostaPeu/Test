package erp.gw.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.common.domain.PageMaker;
import erp.common.domain.SearchCriteria;
import erp.common.service.CommonService;
import erp.gw.projectboard.domain.ProjectsVO;
import erp.gw.projectboard.service.ProjectBoardService;

@Controller
@RequestMapping("/groupware/project_board")
public class ProjectBoardController {
	
	@Inject
	private ProjectBoardService service;
	
	@Inject
	private CommonService common;
	
	@RequestMapping(value="/pb_myproject_list", method=RequestMethod.GET)
	public void myProjectList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{		
		List<ProjectsVO> pList = service.listSearchCriteria(cri);
		model.addAttribute("list", pList);
		ProjectsVO pro = new ProjectsVO();
		
		List<String> eNameList = new ArrayList<String>();

		for(int i=0; i<pList.size(); i++){
			pro=pList.get(i);
			String name = service.enameGet(pro.getEmp_id());
			eNameList.add(name);
		}
		
		model.addAttribute("e_name_list", eNameList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/pb_myproject_view", method = RequestMethod.GET)
	public void read(@RequestParam("proj_id") int proj_id, @ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		ProjectsVO pro = service.read(proj_id);
		model.addAttribute("project", pro);
		model.addAttribute("e_name", service.enameGet(pro.getEmp_id()));
	}
	
	@RequestMapping(value="/pb_myproject_write", method = RequestMethod.GET)
	public void writeGET(ProjectsVO project)throws Exception{
	}
	
	@RequestMapping(value="/pb_myproject_write", method=RequestMethod.POST)
	public String writePOST(ProjectsVO project, Model model)throws Exception{
		String emp_id=common.getEmployeeId();
		Date start = project.getProj_start_date();
		Date end = project.getProj_end_date();
		
		long day = end.getTime() - start.getTime();
		int minus = (int)day/(1000*60*60*24);
		System.out.println("일 수 : "+minus);
		project.setEmp_id(emp_id);
		project.setProj_period(minus);
		service.write(project);
		return "redirect:/groupware/project_board/pb_myproject_list";
	}
	
}
