# -*- coding: utf-8 -*-
"""
Created on Sat Apr 28 21:43:49 2018

@author: liuzhiyuan
"""
from selenium import webdriver
import pymysql
import CreateURL

#链接数据库 
conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='123456', db='bysj',charset='utf8')
#打开游标
cursor = conn.cursor()

#设置浏览器参数
options = webdriver.ChromeOptions()
options.add_argument('user-agent="Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19"')
#创建启动浏览器
driver = webdriver.Chrome(chrome_options = options,executable_path='C:\Program Files lzy\ChromeDriver\chromedriver.exe')
#获取URL,从股票代码sz0000001到sz0000100
txUrl = CreateURL.CreateTxUrl(2,100)
#由url地址开启网页（实际上并没有执行这个，而是自己手打的string）
driver.get(txUrl)
#获取到class=list的table标签下的所需信息
try:
    i = 2 
    #此处有待修改
    while i < 150 :
        xpath_string1 = "//table[@class='list']/tbody/tr["+str(i)+"]/td[1]/a"
        xpath_string2 = "//table[@class='list']/tbody/tr["+str(i)+"]/td[2]"
        xpath_string3 = "//table[@class='list']/tbody/tr["+str(i)+"]/td[3]/a"
        elem1 = driver.find_element_by_xpath(xpath_string1)
        elem2 = driver.find_element_by_xpath(xpath_string2)
        elem3 = driver.find_element_by_xpath(xpath_string3)
        i = i + 1
        print(str(elem3.text), str(elem1.text), str(elem2.text), str(elem1.get_attribute('href')))
        #将获取到的信息存入数据库
        cursor.execute('insert into news_list values("%s","%s","%s","%s")' % \
                   (str(elem3.text), str(elem1.text), str(elem2.text), str(elem1.get_attribute('href'))))
        conn.commit()
    
except BaseException :
    #关闭游标和数据库连接
    print("this is finish")
    
    cursor.close()
    conn.close()