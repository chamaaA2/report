package com.ust.dj.dynamicfailgrps;


import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;

import java.awt.*;

/**
 * @author Kushan
 */
public class ReportTemplateForDJ {

    public static final Style detailStyle;
    public static final Style headerStyle;
	public static final Style headerVariables;

	public static final Style groupVariables;
	public static final Style titleStyle;
	public static final Style importeStyle;
	public static final Style oddRowStyle;

	public static final Style rootStyle;
	public static final Style columnStyle;
	public static final Style columnTitleStyle;
	public static final Style groupStyle;
	public static final Style subtotalStyle;
	public static final Style noneStyle;

	public static final Style subGroupFooterColor ;

	static {
		rootStyle = new Style("root");
		Font customArial = Font.ARIAL_MEDIUM;
		customArial.setFontSize(8);//Set Font Size
		rootStyle.setFont(customArial);

		detailStyle = new Style("detail");

		headerStyle = new Style("header");
		headerStyle.setFont(Font.ARIAL_MEDIUM_BOLD);
		headerStyle.setBorderBottom(Border.PEN_1_POINT());
		headerStyle.setBackgroundColor(Color.gray);
		headerStyle.setTextColor(Color.white);
		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);

		headerVariables = new Style("headerVariables");
		headerVariables.setFont(Font.ARIAL_BIG_BOLD);
		headerVariables.setBorderBottom(Border.THIN());
		headerVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
		headerVariables.setVerticalAlign(VerticalAlign.TOP);
		headerVariables.setStretchWithOverflow(true);

		groupVariables = new Style("groupVariables");
		groupVariables.setFont(Font.ARIAL_MEDIUM_BOLD);
		groupVariables.setTextColor(Color.BLUE);
		groupVariables.setBorderBottom(Border.THIN());
		groupVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
		groupVariables.setVerticalAlign(VerticalAlign.BOTTOM);

		titleStyle = new Style("titleStyle");
		titleStyle.setFont(Font.ARIAL_MEDIUM_BOLD);

		importeStyle = new Style();
		importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);

		oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER());
		oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);


		noneStyle = new Style("none","root");
		noneStyle.setTextColor(new Color(111, 112, 114));

		columnStyle = new Style("columnStyle");

		columnTitleStyle = new Style();
		columnTitleStyle.setPadding(4);
		columnTitleStyle.setTextColor(new Color(77,77,79));
		columnTitleStyle.setBackgroundColor(Color.WHITE);
		columnTitleStyle.setFont(Font.ARIAL_MEDIUM);

		groupStyle    = new Style("group","columnStyle");
		groupStyle.setBorder(Border.PEN_1_POINT());
		groupStyle.setPaddingTop(6);
		groupStyle.setPaddingLeft(10);
		groupStyle.setPaddingBottom(6);

		groupStyle.setBackgroundColor(new Color(0,156,222));
		groupStyle.setTextColor(Color.WHITE);
		groupStyle.setFont(Font.ARIAL_MEDIUM);


		subtotalStyle       = new Style("subtotalStyle","root");

		subGroupFooterColor = new Style();
		subGroupFooterColor.setTextColor(new Color(77,77,79));
		subGroupFooterColor.setBackgroundColor(new Color(192, 190, 190));
		subGroupFooterColor.setFont(Font.ARIAL_MEDIUM_BOLD);

	}

}
