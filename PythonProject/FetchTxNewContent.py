# -*- coding: utf-8 -*-
"""
Created on Mon Apr 30 21:55:11 2018

@author: liuzhiyuan
"""
from selenium import webdriver
import pymysql


#链接数据库 
conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='123456', db='bysj',charset='utf8')
#打开游标
cursor = conn.cursor()
#获取新闻的所有链接
sql_find_href = "select new_href from news_list"
cursor.execute(sql_find_href)
tuple_url = cursor.fetchall()
#设置浏览器参数
options = webdriver.ChromeOptions()
options.add_argument('user-agent="Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19"')
#循环爬取列表链接中的新闻
i = 145
while i < 148 :
    new_url = tuple_url.__getitem__(i)
    #创建启动浏览器
    driver = webdriver.Chrome(chrome_options = options,executable_path='C:\Program Files lzy\ChromeDriver\chromedriver.exe')
    #使用第一个URL进行爬取,此处一定是填0
    driver.get(new_url[0])
    #获取到class=list的table标签下的所需信息
    xpath_newtitle = "//div[@class='jsx-968600005 ']/div[1]/h1[1]"
    xpath_newdate = "//div[@class='jsx-968600005 ']/div[1]/div[1]/div[1]"
    xpath_newcontent = "//div[@class='jsx-968600005 ']/div[2]"
    newtitle = driver.find_element_by_xpath(xpath_newtitle)
    newdate = driver.find_element_by_xpath(xpath_newdate)
    newcontent = driver.find_element_by_xpath(xpath_newcontent)
    #查询出公司名字
    sql_find_companyname = "select company_name from news_list"
    cursor.execute(sql_find_companyname)
    tuple_companyname = cursor.fetchall()
    companyname = tuple_companyname.__getitem__(i)
    #写入数据库
    cursor.execute('insert into news_content values("%s","%s","%s","%s")' % \
                       (str(companyname[0]), str(newtitle.text), str(newcontent.text), str(newdate.text)))
    conn.commit()
    #关闭浏览器
    driver.close()
    i = i + 1
#关闭游标
cursor.close()
