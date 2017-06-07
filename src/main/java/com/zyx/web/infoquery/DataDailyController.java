package com.zyx.web.infoquery;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.zyx.model.Page;
import com.zyx.model.PageData;
import com.zyx.service.infoquery.DataDailyService;
import com.zyx.util.Tools;
import com.zyx.web.WebController;
import com.zyx.service.system.DictionariesService;
/** 
 * 说明：
 * 创建人：kbky
 * 创建时间：
 */
@Controller("infoqueryDataDailyController")
@RequestMapping(value="/infoquery")
public class DataDailyController extends WebController {
	
	@Autowired
	private DataDailyService infoqueryDataDailyService;
	@Autowired
	private DictionariesService dictionariesService;
	
	/*
	 * 查询
	 */
	@RequestMapping("/datadailyList")
	public String list(Map<String, Object> map) throws Exception{
		PageData pd = this.getPageData();
		int pageNum = Page.getPageNum(pd);
		int pageSize = Page.getPageSize(pd);
		List<Map<String, Object>> list = infoqueryDataDailyService.listService(pageNum, pageSize, pd);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		map.put("page", pageInfo);
		map.put("datadailyList", list);
		map.put("pd", pd);
		return "/infoquery/datadaily/datadaily_list";
	}
	
	/*
	 * 保存
	 */
	@RequestMapping("/datadailySave")
	@ResponseBody
	public String save(Map<String, Object> map) throws Exception{
		return infoqueryDataDailyService.saveService(getPageData());
	}
	
	/*
	 * 修改
	 */
	@RequestMapping("/datadailyUpdate")
	@ResponseBody
	public String update(Map<String, Object> map) throws Exception{
		return infoqueryDataDailyService.updateService(getPageData());
	}
	
	/*
	 * 删除
	 */
	@RequestMapping("/datadailyDel")
	@ResponseBody
	public String del(Map<String, Object> map) throws Exception{
		return infoqueryDataDailyService.delService(getPageData());
	}
	
	/*
	 * 跳转到新增页面
	 */
	@RequestMapping("/datadailyAdd")
	public String add(Map<String, Object> map) throws Exception{
		PageData pd = getPageData();
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "SHOP_CODE_OUT");
		map.put("shopcodeoutList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "DIRECTION");
		map.put("directionList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "CUSTR_TYPE");
		map.put("custrtypeList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "STATUS");
		map.put("statusList", dictionariesService.listDicService(pd));
		map.put("action", "Save");
		map.put("pd", pd);
		map.put("url", Tools.getStringValue(pd.get("url")));
		return "/infoquery/datadaily/datadaily_edit";
	}
	
	/*
	 * 跳转到修改页面
	 */
	@RequestMapping("/datadailyEdit")
	public String edit(Map<String, Object> map) throws Exception{
		PageData pd = getPageData();
		Map<String, Object> result = infoqueryDataDailyService.editService(pd);
		map.put("datadaily", result);
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "SHOP_CODE_OUT");
		map.put("shopcodeoutList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "DIRECTION");
		map.put("directionList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "CUSTR_TYPE");
		map.put("custrtypeList", dictionariesService.listDicService(pd));
		pd.put("TABLE_NAME", "BON_DATA_DAILY_TBL");
		pd.put("TABLE_COLUMN", "STATUS");
		map.put("statusList", dictionariesService.listDicService(pd));
		map.put("action", "Update");
		map.put("pd", pd);
		map.put("url", Tools.getStringValue(pd.get("url")));
		return "/infoquery/datadaily/datadaily_edit";
	}
	
	/*
	 * 跳转到详情页面
	 */
	@RequestMapping("/datadailyDetail")
	public String detail(Map<String, Object> map) throws Exception{
		PageData pd = getPageData();
		Map<String, Object> result = infoqueryDataDailyService.editService(pd);
		map.put("datadaily", result);
		map.put("pd", pd);
		map.put("url", Tools.getStringValue(pd.get("url")));
		return "/infoquery/datadaily/datadaily_detail";
	}
}
