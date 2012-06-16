/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	
	config.toolbar = 'MyToolbar';
	config.toolbar_MyToolbar = 
	[
	 	['Source', '-', 'Bold', 'Italic', 'Underline', '-', 'JustifyLeft','JustifyCenter','JustifyRight', 'JustifyBlock', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink', '-', 'Image', 'HorizontalRule', '-', 'Smiley'],
	 	'/',
	 	['Styles','Format','Font','FontSize', '-', 'TextColor','BGColor', '-', 'Maximize']
	];
	                            
	config.width = 670;
	config.resize_enabled = false;
	config.enterMode = CKEDITOR.ENTER_BR;
};
