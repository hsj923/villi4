/*
 * package com.lec.jdbc.impl;
 * 
 * import java.util.List;
 * 
 * import javax.annotation.PostConstruct;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.PropertySource; import
 * org.springframework.core.env.Environment; import
 * org.springframework.stereotype.Service;
 * 
 * import com.lec.jdbc.common.SearchVO; import
 * com.lec.jdbc.service.BoardService; import com.lec.jdbc.service.CsService;
 * import com.lec.jdbc.vo.CsVO; import com.lec.jdbc.vo.PageInfo;
 * 
 * 
 * @Service("csService") public class CsServiceImpl implements CsService {
 * 
 * @Autowired private com.lec.jdbc.dao.CsDAO CsDAO;
 * 
 * @Override public CsVO getCs(CsVO cs) { return CsDAO.getCs(cs); }
 * 
 * 
 * @Override public PageInfo getPageInfo(int currentPage, int perPage) { return
 * CsDAO.getPageInfo("cs", currentPage, perPage); }
 * 
 * @Override public List<CsVO> getCsList(int currentPage, int perPage) { return
 * CsDAO.getCsList(currentPage, perPage); }
 * 
 * @Override public int insertCs(CsVO cs) { return CsDAO.insertCs(cs); }
 * 
 * @Override public int updateCs(CsVO cs) { return CsDAO.updateCs(cs); }
 * 
 * @Override public int deleteCs(CsVO cs) { return CsDAO.deleteCs(cs); }
 * 
 * // @Override // public int detailCs(CsVO cs) { // return CsDAO.detailCs(cs);
 * // }
 * 
 * -----------------------------------------------------------------------------
 * -
 * 
 * @Override public List<CsVO> getCsList(SearchVO searchVO) { return
 * CsDAO.getCsList(searchVO); }
 * 
 * @Override public int getTotalRowCount(SearchVO searchVO) { return
 * CsDAO.getTotalRowCount(searchVO); }
 * 
 * 
 * 
 * 
 * 
 * }
 */