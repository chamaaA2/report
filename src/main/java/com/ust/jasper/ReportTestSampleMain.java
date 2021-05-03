package com.ust.jasper;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.builder.group.CustomGroupBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.export;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

public class ReportTestSampleMain {

    public static void main(String[] args) throws Exception {
        SubreportBuilder stockLoanActivity = cmp.subreport(new StockLoanExpression())
                .setDataSource(new StockLoanDatasource());
        InputStream is = ReportTestSampleMain.class.getResourceAsStream("/META-INF/trainTemplate.jrxml");
        JasperPdfExporterBuilder pdfExporter = export.pdfExporter("C:\\Users\\CHAMATH\\Desktop\\test.pdf");
        report()
                .setTemplate(ReportTemplate.reportTemplate)
                .setTemplateDesign(is)
                .addNoData(cmp.text("None").setStyle(ReportTemplate.noneStyle))
                .title(stockLoanActivity)
                .setPageMargin(margin().setLeft(52).setBottom(30).setTop(50).setRight(52))
                .toPdf(pdfExporter);
    }
    //chamath add
}
class StockLoanExpression extends AbstractSimpleExpression<JasperReportBuilder> {

    private static final long serialVersionUID = 10L;
    CustomGroupBuilder symbolGroup = grp.group(new SymbolExpression()).addHeaderComponent(cmp.verticalGap(6).setStyle(stl.style().setBackgroundColor(Color.WHITE).setBottomPadding(10)))
            .addFooterComponent(cmp.verticalGap(6).setStyle(stl.style().setBackgroundColor(Color.WHITE).setBottomPadding(10)
                    .setLeftBorder(stl.pen(Float.valueOf(5), LineStyle.SOLID).setLineColor(Color.WHITE))
                    .setRightBorder(stl.pen(Float.valueOf(5), LineStyle.SOLID).setLineColor(Color.WHITE))
                    .setBottomBorder(stl.pen(Float.valueOf(5), LineStyle.SOLID).setLineColor(Color.WHITE))));
    public StockLoanExpression()  {

    }
    @Override
    public JasperReportBuilder evaluate(ReportParameters reportParameters) {

        TextColumnBuilder[] loanColumnBuilders = {
                col.column("Date", "date", type.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(8),
                col.column("Action", "desc", type.stringType()).setStyle(ReportTemplate.detailWithLeftLineStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(12),
                col.column("Quantity", "quantity", type.integerType()).setStyle(ReportTemplate.detailWithLeftLineStyle).setWidth(6),
                col.column("Interest Rate (%)", "interestRate", type.bigDecimalType()).setValueFormatter(new ValueFormatter()).setStyle(ReportTemplate.detailWithLeftLineStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(6),
                col.column("Collateral Change", "collateralChange", type.bigDecimalType()).setValueFormatter(new CurrencyFormatter()).setStyle(ReportTemplate.detailWithLeftLineStyle).setWidth(8),
                col.column("Collateral Amount", "collateralAmount", type.bigDecimalType()).setValueFormatter(new CurrencyFormatter()).setStyle(ReportTemplate.detailWithLeftLineStyle).setWidth(6),
                col.column("Interest Amount", "interestAmount", type.bigDecimalType()).setValueFormatter(new CurrencyFormatter()).setStyle(ReportTemplate.detailWithRightBorderStyle).setWidth(6),
        };
        Map<String, TextColumnBuilder> loanColMap = Arrays.stream(loanColumnBuilders).collect(Collectors.toMap(TextColumnBuilder::getName, o -> o));
        JasperReportBuilder report = report();
        report.setTemplate(ReportTemplate.reportTemplate);
        report.addNoData(cmp.text("None").setStyle(ReportTemplate.noneStyle));
        report.columns(loanColumnBuilders)
                .setSubtotalStyle(ReportTemplate.subGroupFooterColor)
                .groupBy(symbolGroup)
                .subtotalsAtGroupFooter(symbolGroup,
                        sbt.first(new SideStockExpression(), loanColMap.get("date")).setStyle(ReportTemplate.leftAlignStyleBold),
                        sbt.first(new TestStockExpression(), loanColMap.get("quantity")).setStyle(ReportTemplate.rightAlignStyleBold),
                        sbt.first(new TestStockExpression(), loanColMap.get("interestAmount")).setStyle(ReportTemplate.rightAlignStyleBold),
                        sbt.first(new TestStockExpression(), loanColMap.get("collateralAmount")).setStyle(ReportTemplate.rightAlignStyleBold))
                .setGroupFooterStyle(symbolGroup, ReportTemplate.subGroupFooterColor);
        return report;
    }
}

class StockLoanDatasource extends AbstractSimpleExpression<JRDataSource> {

    private static final long serialVersionUID = 11L;
    private List<SLBean> data = new LinkedList<>();
    private Map<String,Map<String,BigDecimal>> onLoanQtyMap1 = new HashMap<>();

    public StockLoanDatasource() throws Exception {

    }

    @Override

    public JRDataSource evaluate(ReportParameters reportParameters) {

        String[] columns = {"loanId", "date","desc", "quantity", "interestRate", "collateralChange", "collateralAmount", "interestAmount","symbol","rcc"};
        DRDataSource dataSource = new DRDataSource(columns);

            for (int i = 0; i < 10; i++) {
                data.add(new SLBean(0L,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,i,"ss",(i%3==0)?"AAPL":"BAC",String.valueOf(i%2)));
            }
        Collections.sort(data);
        for (SLBean bean : data) {
            Object[] data = {bean.getLoanId(),"2020/01/02",bean.getDesc(),bean.getQuantity(),bean.getInterestRate(),bean.getCollateralChange(),bean.getCollateralAmount(),bean.getInterestAmount(),bean.getSymbol(),bean.getRcc()};
            dataSource.add(data);
        }

        return dataSource;

    }
}


class SideStockExpression extends AbstractSimpleExpression<String> {
    private static final long serialVersionUID = 2001L;

    @Override
    public String evaluate(ReportParameters reportParameters) {
        return "Total Loan";
    }

}
class TestStockExpression extends AbstractSimpleExpression<String> {
    private static final long serialVersionUID = 2001L;

    @Override
    public String evaluate(ReportParameters reportParameters) {
        return "0";
    }

}
class SymbolExpression extends AbstractSimpleExpression<String> {
    private static final long serialVersionUID = 102L;

    @Override
    public String evaluate(ReportParameters reportParameters) {
        return "ss";
    }
}
class ValueFormatter extends AbstractValueFormatter<String, BigDecimal> {
    public String format(BigDecimal value, ReportParameters reportParameters) {
        return "100";
    }
}

class CurrencyFormatter extends AbstractValueFormatter<String, BigDecimal> {
    public String format(BigDecimal value, ReportParameters reportParameters) {
        if(value == null)
            return "";

        String repeated = new String(new char[2]).replace("\0", "0");
        DecimalFormat decimalFormat = new DecimalFormat("#0." + repeated);

        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        if (value.signum() == -1)
            return "-$" + decimalFormat.format(value.negate());
        else
            return "$" + decimalFormat.format(value);
    }
}