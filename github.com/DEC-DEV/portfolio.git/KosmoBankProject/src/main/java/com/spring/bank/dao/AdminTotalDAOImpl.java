package com.spring.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bank.dto.TotalChartDTO;
@Repository
public class AdminTotalDAOImpl implements AdminTotalDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public TotalChartDTO productsignTotal() {
		return sqlSession.getMapper(AdminTotalDAO.class).productsignTotal();
	}

	@Override
	public  List<TotalChartDTO>loans_product_blanace() {
		return sqlSession.getMapper(AdminTotalDAO.class).loans_product_blanace();
	}

	@Override
	public  List<TotalChartDTO> fund_product_blanace() {
		return sqlSession.getMapper(AdminTotalDAO.class).fund_product_blanace();
	}

	@Override
	public List<TotalChartDTO> deposit_blanace(Map<String,String> map) {
		return sqlSession.getMapper(AdminTotalDAO.class).deposit_blanace(map);
	}

	@Override
	public List<TotalChartDTO> saving_blanace(Map<String,String> map) {
		return sqlSession.getMapper(AdminTotalDAO.class).saving_blanace(map);
	}

	@Override
	public List<TotalChartDTO> loansTotal() {
		return sqlSession.getMapper(AdminTotalDAO.class).loansTotal();
	}

	@Override
	public List<TotalChartDTO> fundTotal() {
		return sqlSession.getMapper(AdminTotalDAO.class).fundTotal();
	}

	@Override
	public List<TotalChartDTO> loansbarChartTotal() {
		return sqlSession.getMapper(AdminTotalDAO.class).loansbarChartTotal();
	}

}
