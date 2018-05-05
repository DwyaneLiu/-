<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head class="ui semantic">
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <!-- //<meta http-equiv="X-UA-Compatible" content="ie=edge"> -->
    <title>search page</title>
    <link href="http://ox6yf62u0.bkt.clouddn.com/semantic-ui/2.2.13/semantic.min.css" rel="stylesheet">
    <script src="http://ox6yf62u0.bkt.clouddn.com/jquery-2.1.4.min.js"></script>
    <script src="http://ox6yf62u0.bkt.clouddn.com/semantic-ui/2.2.13/semantic.min.js"></script>
    <style>
    .topheader>a {
        padding-right: 15px;
        color: black;
        background-color: #fff;
        /* text-decoration:underline; */
        font-weight: bold;
    }

    a {
        text-decoration: underline;
        color: rgba(109, 99, 99, 0.76);
        font-size: 5px;
    }


    .bri {
        display: inline-block;

        right: 10px;
        width: 60px;
        height: 23px;

        color: #fff;
        background: #38f;
        line-height: 24px;
        font-size: 13px;
        text-align: center;
        overflow: hidden;
        /*border-bottom: 1px solid #38f;*/
        margin-left: 19px;
        margin-right: 2px;
    }
    </style>
</head>

<body>
    <!-- top link start -->
    <div class="ui right aligned  topheader fluid container" style="padding: 60px">
        <div href="#" class="bri" style1="background-color: rgba(7, 28, 219, 0.952);text-decoration: none;color:white;padding-right: 0;display:inline-block;width:70px;height:15px;">
        	腾讯财经
        </div>
        <div href="#" class="bri" style1="background-color: rgba(7, 28, 219, 0.952);text-decoration: none;color:white;padding-right: 0;display:inline-block;width:70px;height:15px;">
			新浪财经
        </div>
        <div href="#" class="bri" style1="background-color: rgba(7, 28, 219, 0.952);text-decoration: none;color:white;padding-right: 0;display:inline-block;width:70px;height:15px;">
			东方财富
        </div>
        <div href="#" class="bri" style1="background-color: rgba(7, 28, 219, 0.952);text-decoration: none;color:white;padding-right: 0;display:inline-block;width:70px;height:15px;">
        	用户:${currentUser.username}
        </div>
        <div href="#" class="bri" style1="background-color: rgba(7, 28, 219, 0.952);text-decoration: none;color:white;padding-right: 0;display:inline-block;width:70px;height:15px;">
        	重新登陆
        </div>
    </div>
    <!-- top link end -->
    <div class="ui centered aligned grid container ">
        <div class="row">
            <div class="column" style="width: 270px;height: 129px;">
                <img class="ui  image" src="WEB-Page/Login/images/login/fly.png" alt="">
                <p>搜	股</p>
            </div>
        </div>
        <div class="row">
            <form class="column" style="width:640px;" method="GET" action="find_news_list" name="search">
                <div class="ui fluid  input action">
                    <input type="text" id="companyname" name="companyname" placeholder="搜索公司名">
                    <input type="submit" class="medium ui blue button" value="搜索" />
                </div>
            </form>
        </div>
    </div>
    
</body>

</html>