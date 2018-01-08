disappearing navigation entry
=============================

A sample project to demonstrate a flickering grid and disappearing navigation entry on the latest Vaadin 8.2.0 release.

This issue has been following us since switching to TreeGrid with Vaadin 8 and can still be repoduced in the latest 8.1.7 or 8.2.0 Vaadin release.

Vaadin Issue #10501 on GitHub: https://github.com/vaadin/framework/issues/10501

Project Usage
=============

To compile the entire project, run "mvn install" using Maven > 3.

To run the application, run "mvn jetty:run" and open http://localhost:8080/ 
- then use the navigation on the left to select "Item 4" and then alternating items below

Notice that the grid starts to "flicker" below a specific navigation entry during reloads and at some point this one navigation entry disappears.
In the prepared grid that affected item is "Item 4"

Cause?
======

Setting the height of the TreeGrid to 100% causes the problem with flickering grid content and disappearing item
navigationTree.setHeight("100%");

Workaround
==========

Using a fixed height for the TreeGrid and the flickering goes away and the item does no longer disappear
navigationTree.setHeight("700px");
