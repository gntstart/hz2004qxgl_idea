package com.gnt.qxgl.common.dict.bean;

import java.util.List;

import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.hz2004.entity.XT_XZQHB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtJwhxxb;
import com.gnt.qxgl.hz2004.entity.XtXtgnb;
import com.gnt.qxgl.hz2004.entity.XtXtgncdb;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.hz2004.entity.XtYwbbmbxxb;

public class TreeNode implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * null 无复选项 true 有复选，并选中 false 有复选，没选中
	 */
	private Boolean checked;
	
	private Boolean disabled;

	/**
	 * 节点默认是否展开
	 */
	private boolean expanded = false;
	/**
	 * text属性为节点的显示文字，必须
	 */
	private String text;
	/**
	 * 节点是否最终节点，必须： true Ext.tree.TreeNode类型的叶子节点 false 树枝节点，又分下面2中情况：
	 * 提供children 那么创建Ext.tree.TreeNode类型树枝节点 不提供children
	 * 那么创建Ext.tree.AsyncTreeNode类型树枝节点
	 */
	private boolean leaf;
	
	/**
	 * 本节点的子节点列表，当leaf为false时有效
	 */
	private List<TreeNode> children;

	private String pid; 						// 存放父亲节点数据
	private Code code; 						// 普通字典
	private String codevalue;						//字典值
	private SysOrganizeInfo zzjg; 		// 组织结构
	private XtYhxxb zzjy; 				// 组织警员
	private SysFunctionInfo zy; 			// 资源
	private String qtip; 						// 节点提示信息
	private String pathcode; 				// 用于展开树的属性
	private String icon;
	private String iconCls;
	private XtJsxxb js;
	private XT_XZQHB xzqh;			//行政区划
	private XtJwhxxb jwh;			//居委会
	private XtDwxxb dw;			//普通单位
	private XtXtgncdb gncdb;
	private XtXtgnb gnb;
	private XtYwbbmbxxb ywmb;

	//下面为下拉菜单准备
	private TreeNode menu;
	private List items;
	private String handler;
	
	public String getCodevalue() {
		return codevalue;
	}

	public void setCodevalue(String codevalue) {
		this.codevalue = codevalue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public XtYwbbmbxxb getYwmb() {
		return ywmb;
	}

	public void setYwmb(XtYwbbmbxxb ywmb) {
		this.ywmb = ywmb;
	}
	
	public XtXtgnb getGnb() {
		return gnb;
	}

	public void setGnb(XtXtgnb gnb) {
		this.gnb = gnb;
	}

	public XtXtgncdb getGncdb() {
		return gncdb;
	}

	public void setGncdb(XtXtgncdb gncdb) {
		this.gncdb = gncdb;
	}

	public XtDwxxb getDw() {
		return dw;
	}

	public void setDw(XtDwxxb dw) {
		this.dw = dw;
	}

	public XT_XZQHB getXzqh() {
		return xzqh;
	}

	public void setXzqh(XT_XZQHB xzqh) {
		this.xzqh = xzqh;
	}

	public XtJwhxxb getJwh() {
		return jwh;
	}

	public void setJwh(XtJwhxxb jwh) {
		this.jwh = jwh;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public TreeNode getMenu() {
		return menu;
	}

	public void setMenu(TreeNode menu) {
		this.menu = menu;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public String getQtip() {
		return qtip;
	}

	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public SysOrganizeInfo getZzjg() {
		return zzjg;
	}

	public void setZzjg(SysOrganizeInfo zzjg) {
		this.zzjg = zzjg;
	}

	public XtYhxxb getZzjy() {
		return zzjy;
	}

	public void setZzjy(XtYhxxb zzjy) {
		this.zzjy = zzjy;
	}

	public SysFunctionInfo getZy() {
		return zy;
	}

	public void setZy(SysFunctionInfo zy) {
		this.zy = zy;
	}

	public XtJsxxb getJs() {
		return js;
	}

	public void setJs(XtJsxxb js) {
		this.js = js;
	}
}