$(document).ready(function () {
var data = [{"text":"Tables","icon":"images/folder.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\Tables.html","target":"DATA","nodes":[{"text":"bandtype","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\bandtype.html","target":"DATA"},{"text":"mount","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\mount.html","target":"DATA"},{"text":"mountlocation","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\mountlocation.html","target":"DATA"},{"text":"retread","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\retread.html","target":"DATA"},{"text":"tire","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\tire.html","target":"DATA"},{"text":"tirebrand","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\tirebrand.html","target":"DATA"},{"text":"tiremodel","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\tiremodel.html","target":"DATA"},{"text":"tiresituation","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\tiresituation.html","target":"DATA"},{"text":"truck","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\truck.html","target":"DATA"},{"text":"unmount","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\unmount.html","target":"DATA"},{"text":"unmountreason","icon":"images/table.svg","href":"Servers\\mydb.localhost\\Databases\\mydb\\Tables\\unmountreason.html","target":"DATA"}]}];
$('#tree').treeview({levels: 3,data: data,enableLinks: true,injectStyle: false,highlightSelected: true,collapseIcon: 'images/tree-node-expanded.svg',expandIcon: 'images/tree-node-collapsed.svg'});
});
var loadEvent = function () {
  
  var searchTimeOut;
  $('#input-search').on('input', function() {
    if(searchTimeOut != null)
      clearTimeout(searchTimeOut);
    searchTimeOut = setTimeout(function(){
      var pattern = $('#input-search').val();
      var tree = $('#tree');
      tree.treeview('collapseAll', { levels:3, silent: true });
      var options = { ignoreCase: true, exactMatch: false, revealResults: true };
      var results = tree.treeview('search', [pattern, options]);
    }, 500);
  });
  
  $('#tree').on('nodeSelected', function(event, data) {
    // navigate to link
    window.open (data.href, 'DATA', false)
  });
  // select first node.
  $('#tree').treeview('selectNode', [0, { silent: false }]);
}

if (window.addEventListener) {
  window.addEventListener('load', loadEvent, false);
}
else if (window.attachEvent) {
  window.attachEvent('onload', loadEvent);
}