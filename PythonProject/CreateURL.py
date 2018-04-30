# -*- coding: utf-8 -*-
"""
Created on Mon Apr 30 01:48:07 2018

@author: liuzhiyuan
"""
def CreateCoCode(start_num,end_num):
    
    i = start_num
    j = end_num
    CoCodes = [];
    
    if j < 10 :
        while i <= j :   
            code = "sz000000"+str(i)
            
            i = i + 1
            
            CoCodes.append(code)           
    if j < 100 : 
        while i <= j :   
            code = "sz00000"+str(i)
            
            i = i + 1
            
            CoCodes.append(code)
    if j < 1000:
        while i <= j :   
            code = "sz0000"+str(i)
            
            i = i + 1
            
            CoCodes.append(code)
        
    return CoCodes

def CreateTxUrl(start_num,end_num) :
    
    Codes = CreateCoCode(start_num,end_num)
    UrlCode = ''
    for code in Codes :
        UrlCode = UrlCode+code+','     
    TxUrl = 'http://finance.qq.com/stock/sother/news.htm?q='+UrlCode 
    TxUrl = TxUrl.rstrip(',')   
    return TxUrl


#if __name__ == "__main__" :
#    print(CreateTxUrl(1,22))
    