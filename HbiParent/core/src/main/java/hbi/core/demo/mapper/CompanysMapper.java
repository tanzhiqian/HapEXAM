package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.Companys;

public interface CompanysMapper extends Mapper<Companys> {
	List<Companys> selectByCompanys(Companys companys);

	int insertCompanys(Companys companys);

	int deleteCompanys(Companys companys);

	int updateCompanys(Companys companys);
}
