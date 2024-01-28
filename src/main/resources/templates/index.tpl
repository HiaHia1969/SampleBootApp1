yieldUnescatped '<!DOCTYPE html>'

html(lang:'ja') {
	head {
		meata(charset:"UTF-8")
		title(title)
		link(rel:"stylesheet", type:"text/css",
			href:"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css")
	}
	
	body(class:"container"){
		h1(class:"display-4", title)
		
		p("Flag: $flag.")
		
		
		include template:"content.tpl"
		
		if(flag) {
			div(class:"alert alert-primary"){
				h6(msg)
			}
		} else {
			p("no message...")
		}
		
		ul(class:"list-group"){
			data.each { item ->
				li(class:"list-group-item", item)
			}
		}
		
		br()
		
		ul(class:"list-group"){
			for(da in data2){
				li(class:"list-group-item", da)
			}
		}
		
		br()
		
		ul(class:"list-group"){
			data.each {
				fragment "li(class:'list-group-item', item)", item:it
			}
		}
	}
}