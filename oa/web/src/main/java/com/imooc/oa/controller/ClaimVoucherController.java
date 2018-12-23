package com.imooc.oa.controller;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dto.ClaimVoucherInfo;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    private ClaimVoucherBiz claimVoucherBiz;

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map){
        map.put("items", Contant.getItems());
        map.put("info", new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, ClaimVoucherInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(info.getClaimVoucher(), info.getItems());
        return "redirect:detail?id="+info.getClaimVoucher().getId();
    }

    @RequestMapping("detail")
    public String detail(int id, Map<String, Object> map){
        map.put("claimVoucher", claimVoucherBiz.get(id));
        map.put("items", claimVoucherBiz.getItems(id));
        map.put("records", claimVoucherBiz.getRecords(id));

        return "claim_voucher_detail";

    }

    @RequestMapping("/self")
    public String self(HttpSession session, Map<String, Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list", claimVoucherBiz.getForSelf(employee.getSn()));
        return "claim_voucher_self";

    }

    @RequestMapping("/deal")
    public String deal(HttpSession session, Map<String, Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list", claimVoucherBiz.getForDeal(employee.getSn()));
        return "claim_voucher_deal ";

    }
}
