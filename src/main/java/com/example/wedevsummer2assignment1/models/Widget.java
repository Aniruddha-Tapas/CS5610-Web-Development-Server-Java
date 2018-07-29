package com.example.wedevsummer2assignment1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int orderNumber;
    private String text;
    private String widgetType;
    private String style;
    private String height;
    private String width;
    private int size;
    private String href;
    private String src;
    private String listItems;
    private ListType listType;
    @ManyToOne
    @JsonIgnore
    private Topic topic;

    public Widget() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getListItems() {
        return listItems;
    }

    public void setListItems(String listItems) {
        this.listItems = listItems;
    }

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setWidget(Widget widget) {
        this.name = widget.name != null ?
                widget.name : this.name;
        this.orderNumber = widget.orderNumber > 0 ?
                widget.orderNumber : this.orderNumber;
        this.text = widget.text != null ?
                widget.text : this.text;
        this.widgetType = widget.widgetType != null ?
                widget.widgetType : this.widgetType;
        this.style = widget.style != null ?
                widget.style : this.style;
        this.height = widget.height != null ?
                widget.height : this.height;
        this.width = widget.width != null ?
                widget.width : this.width;
        this.size = widget.size > 0 ?
                widget.size : this.size;
        this.href = widget.href != null ?
                widget.href : this.href;
        this.src = widget.src != null ?
                widget.src : this.src;
        this.listItems = widget.listItems != null ?
                widget.listItems : this.listItems;
        this.listType = widget.listType != null ?
                widget.listType : this.listType;
    }
}