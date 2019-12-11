

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Royal Family Tree - OrgChart JS | BALKANGraph</title>
    <style>
        html, body {
    margin: 0px;
    padding: 0px;
    width: 100%;
    height: 100%;
    font-family: Helvetica;
}

#tree {
    width: 100%;
    height: 100%;
}


    </style>

</head>
<body>
     <script type="text/JavaScript" src="bootstrap/js/OrgChart.js"></script>
     <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<div id="tree"></div>
    <script>

window.onload = function () {
    var chart = new OrgChart(document.getElementById("tree"), {
        enableDragDrop: true,
        tags: {
            "assistant": {
                template: "ula"
            }
        },
        nodeBinding: {
            field_0: "name",
            field_1: "title",
            img_0: "img"
        },
        nodes: [
            ${nodes}
        ]
    });
};
    </script>
</body>
</html>
