function subForm(id,url) {
    var f=$("#"+id)[0];
    $.ajax({
        url:f.action,
        method: f.method,
        data:$("#"+id).serialize(),
        success: function (obj) {
            console.log(obj);
            if(obj.code==200){
                location.href=url;
            }else {
                alert(obj.msg);
            }
        }
    });
}