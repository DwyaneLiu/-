# -*- coding: utf-8 -*-
"""
Created on Mon Apr 30 22:06:30 2018

@author: Administrator
"""
from selenium import webdriver
import pymysql

#链接数据库 
conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='123456', db='bysj',charset='utf8')
#打开游标
cursor = conn.cursor()

#
sql_str = "select new_href from news_list"

cursor.execute(sql_str)
w = cursor.fetchall()
s = w.__getitem__(1)
#打印游标所获取的第一行数据
print(s[0])


