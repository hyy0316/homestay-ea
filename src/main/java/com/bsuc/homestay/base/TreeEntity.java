package com.bsuc.homestay.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.List;

/**
 * 树形结构 实体类
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
public abstract class TreeEntity <T extends Model>  extends DataEntity<T>{
    private static final long serialversionUID = 1L;

    // null 父id varchar(64)
    @TableField(value = "parent_id")
    protected Long parentId;

    //节点层次（第一层，第二层..）
    protected Integer level;

    //路径 null varchar(1000)  1.,2,3
    @TableField(value = "parent_ids")
    protected String parentIds;

    //排序 int(11)
    protected Integer sort;

    //子节点 数据库没有
    @TableField(exist = false)
    protected List<T> children;

    //父节点 数据库没有
    @TableField(exist = false)
    protected List<T> parentTree;

    public TreeEntity(){
        super();
        this.sort = 30 ;
    }
    public TreeEntity(Long id){
        super(id);
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public List<T> getParentTree() {
        return parentTree;
    }

    public void setParentTree(List<T> parentTree) {
        this.parentTree = parentTree;
    }
}
