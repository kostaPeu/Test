package erp.gw.projectboard.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import erp.common.domain.Criteria;
import erp.common.domain.SearchCriteria;
import erp.gw.projectboard.domain.ProjectsVO;

@Repository
public class ProjectBoardDaoImpl implements ProjectBoardDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "erp.basic.mapper.pBoardMapper";
	
	@Override
	public List<ProjectsVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<ProjectsVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", null, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}

	@Override
	public List<ProjectsVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public String enameGet(String emp_id) throws Exception {
		return session.selectOne(namespace+".enameGet", emp_id);
	}

	@Override
	public ProjectsVO read(int proj_id) throws Exception {
		return session.selectOne(namespace + ".read", proj_id);
	}

	@Override
	public void write(ProjectsVO project) throws Exception {
		session.insert(namespace + ".write", project);
	}

}
