/**
 * order list
 */
var App = function() {
	var initTable = function() {
		var oTable = $('#dataList').dataTable({
			serverSide: true,
		    ajax: {
		        url: __ctx+'/user/getDatas',
		        type: 'POST'
		    },
			"columns": [{
				"data": "account"
			}, {
				"data": "name"
			}, 	{
				"data": "email"
			},
			{
				"data": function(data){
					var ary = ['<a class="edit" href="#">Edit</a>',
					           '<a class="del" href="#">Del</a>']
					return ary.join(" ");
				}
			}]
		});

		$("#dataListFilterForm .dataListFilterBtn").click(function(e) {
			e.preventDefault();
			oTable.api().columns().every( function () {
			    var data = this.search($('#col'+this.index()+'_filter').val())
			}).draw();
		});

		var keyupTimeout = 1;
		$("#dataListFilterForm input").keyup(function() {
			clearTimeout(keyupTimeout);
			keyupTimeout = window.setTimeout(function() {
				oTable.fnDraw();
			}, 400);
		});

		$("#dataListFilterForm select").change(function() {
			oTable.fnDraw();
		});

		// 作废订单
		oTable.on('click', 'a.del', function(e) {
			e.preventDefault();
			var nRow = $(this).parents("tr")[0];
			var rowData = oTable.api().row(nRow).data();
			if ($(this).hasClass("muted")) {
				return;
			}
			bootbox.confirm("Do you want to delete ?", function(b) {
				if (b) {
					$.post(__ctx + '/user/delete',
						"id=" + rowData["id"],
						function(data) {
							if (data['isSuccess']) {
								//处理成功
								oTable.draw();
							} else {
								bootbox.alert(data['msg']);
							}
						});
				}
			});
		});
		
	};


	return {
		init: function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable();
		}

	};

}();