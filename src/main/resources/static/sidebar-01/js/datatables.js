$(document).ready( function () {
	 var table = $('#feedTable').DataTable({

		 "ajax": {
			 "url": "/feeds/viewFeeds",
			 "type": "GET"
		 },
			"sAjaxSource": "/feeds/viewFeeds",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
				{ "mData": "id"},
			       { "mData": "FeedName"},
			    	{ "mData": "FeedQuality" },
				  { "mData":"UnitPrice" }



			]
	 })
});