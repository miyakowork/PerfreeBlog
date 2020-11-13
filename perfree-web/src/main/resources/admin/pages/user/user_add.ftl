<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"/>
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="stylesheet" href="/public/libs/layui-v2.5.6/layui/css/layui.css">
    <link href="/public/libs/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/admin/static/css/main.css" rel="stylesheet"/>
    <link href="/admin/pages/user/css/user_add.css" rel="stylesheet"/>
</head>
<body>
<div class="p-container p-add-panel">
    <form class="layui-form" lay-filter="addForm">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="userName" required lay-verify="required"  placeholder="请输入用户名" autocomplete="off" class="layui-input" minlength="2" maxlength="16">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">账户:</label>
            <div class="layui-input-block">
                <input type="text" name="account" required minlength="3" maxlength="12"  lay-verify="required" placeholder="请输入账户" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="text" name="password" required minlength="6" maxlength="12" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">角色: </label>
            <div class="layui-input-block">
                <select name="roleId" lay-verify="required" id="roleId">
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态:</label>
            <div class="layui-input-block">
                <select name="status" lay-verify="required">
                    <option value="0">正常</option>
                    <option value="1">禁用</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">头像:</label>
            <div class="layui-input-block">
                <input type="hidden" name="avatar" id="avatar">
                <div class="upload-box">
                    <div class="upload-panel" id="upload">
                        <i class="fa fa-upload" aria-hidden="true"></i>
                    </div>
                    <div class="upload-success-panel" id="uploadSuccessPanel">
                        <img src="">
                        <div class="delete-img-box" id="deleteImg">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="add-btn-box">
            <button type="submit" lay-submit lay-filter="addForm" class="layui-btn layui-btn-normal p-submit-btn">确定</button>
            <button type="button" class="layui-btn layui-btn-primary p-cancel-btn">取消</button>
        </div>
    </form>
</div>

<script src="/public/libs/jquery/jquery-3.5.1.min.js"></script>
<script src="/public/libs/layui-v2.5.6/layui/layui.all.js"></script>
<script src="/admin/pages/user/js/user_add.js"></script>
</body>
</html>