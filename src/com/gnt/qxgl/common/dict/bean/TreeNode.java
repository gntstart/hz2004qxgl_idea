package com.gnt.qxgl.common.dict.bean;

import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.hz2004.entity.XT_XZQHB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtJwhxxb;
import com.gnt.qxgl.hz2004.entity.XtXtgnb;
import com.gnt.qxgl.hz2004.entity.XtXtgncdb;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.hz2004.entity.XtYwbbmbxxb;
import java.util.List;

public class TreeNode
{
  private Boolean checked;
  private Boolean disabled;
  private boolean expanded = false;
  private String text;
  private boolean leaf;
  private List<TreeNode> children;
  private String pid;
  private Code code;
  private String codevalue;
  private SysOrganizeInfo zzjg;
  private XtYhxxb zzjy;
  private SysFunctionInfo zy;
  private String qtip;
  private String pathcode;
  private String icon;
  private String iconCls;
  private XtJsxxb js;
  private XT_XZQHB xzqh;
  private XtJwhxxb jwh;
  private XtDwxxb dw;
  private XtXtgncdb gncdb;
  private XtXtgnb gnb;
  private XtYwbbmbxxb ywmb;
  private TreeNode menu;
  private List items;
  private String handler;

  public String getCodevalue() {
	return codevalue;
}

public void setCodevalue(String codevalue) {
	this.codevalue = codevalue;
}

public XtYwbbmbxxb getYwmb()
  {
    return this.ywmb;
  }

  public void setYwmb(XtYwbbmbxxb ywmb) {
    this.ywmb = ywmb;
  }

  public XtXtgnb getGnb() {
    return this.gnb;
  }

  public void setGnb(XtXtgnb gnb) {
    this.gnb = gnb;
  }

  public XtXtgncdb getGncdb() {
    return this.gncdb;
  }

  public void setGncdb(XtXtgncdb gncdb) {
    this.gncdb = gncdb;
  }

  public XtDwxxb getDw() {
    return this.dw;
  }

  public void setDw(XtDwxxb dw) {
    this.dw = dw;
  }

  public XT_XZQHB getXzqh() {
    return this.xzqh;
  }

  public void setXzqh(XT_XZQHB xzqh) {
    this.xzqh = xzqh;
  }

  public XtJwhxxb getJwh() {
    return this.jwh;
  }

  public void setJwh(XtJwhxxb jwh) {
    this.jwh = jwh;
  }

  public String getHandler() {
    return this.handler;
  }

  public void setHandler(String handler) {
    this.handler = handler;
  }

  public TreeNode getMenu() {
    return this.menu;
  }

  public void setMenu(TreeNode menu) {
    this.menu = menu;
  }

  public List getItems() {
    return this.items;
  }

  public void setItems(List items) {
    this.items = items;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getIconCls() {
    return this.iconCls;
  }

  public void setIconCls(String iconCls) {
    this.iconCls = iconCls;
  }

  public String getPathcode() {
    return this.pathcode;
  }

  public void setPathcode(String pathcode) {
    this.pathcode = pathcode;
  }

  public String getPid() {
    return this.pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public boolean isExpanded() {
    return this.expanded;
  }

  public void setExpanded(boolean expanded) {
    this.expanded = expanded;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isLeaf() {
    return this.leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  public List<TreeNode> getChildren() {
    return this.children;
  }

  public void setChildren(List<TreeNode> children) {
    this.children = children;
  }

  public Code getCode() {
    return this.code;
  }

  public void setCode(Code code) {
    this.code = code;
  }

  public String getQtip() {
    return this.qtip;
  }

  public void setQtip(String qtip) {
    this.qtip = qtip;
  }

  public Boolean getChecked() {
    return this.checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public Boolean getDisabled()
  {
    return this.disabled;
  }

  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  public SysOrganizeInfo getZzjg() {
    return this.zzjg;
  }

  public void setZzjg(SysOrganizeInfo zzjg) {
    this.zzjg = zzjg;
  }

  public XtYhxxb getZzjy() {
    return this.zzjy;
  }

  public void setZzjy(XtYhxxb zzjy) {
    this.zzjy = zzjy;
  }

  public SysFunctionInfo getZy() {
    return this.zy;
  }

  public void setZy(SysFunctionInfo zy) {
    this.zy = zy;
  }

  public XtJsxxb getJs() {
    return this.js;
  }

  public void setJs(XtJsxxb js) {
    this.js = js;
  }
}