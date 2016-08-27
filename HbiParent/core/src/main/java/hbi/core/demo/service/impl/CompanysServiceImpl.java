package hbi.core.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hbi.core.demo.dto.Companys;
import hbi.core.demo.mapper.CompanysMapper;
import hbi.core.demo.service.ICompanysService;

@Service
public class CompanysServiceImpl extends BaseServiceImpl<Companys>implements ICompanysService {
	@Autowired
	private CompanysMapper companysMapper;

	@Override
	public List<Companys> selectByCompanys(IRequest requestContext, Companys companys, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return companysMapper.selectByCompanys(companys);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Companys> batchUpdateCompanys(IRequest requestContext, List<Companys> company) {
		// TODO Auto-generated method stub
		for (Companys companys : company) {
			if (companys.get__status() != null) {
				switch (companys.get__status()) {
				case DTOStatus.ADD:
					companysMapper.insertCompanys(companys);
					break;
				case DTOStatus.UPDATE:
					companysMapper.updateCompanys(companys);
					break;
				case DTOStatus.DELETE:
					self().deleteByPrimaryKey(companys);
					break;
				default:
					break;
				}
			}
		}
		return company;
	}

}
