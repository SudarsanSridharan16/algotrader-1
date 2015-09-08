package com.unisoft.algotrader.provider.ib.api.model.order;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.unisoft.algotrader.utils.collection.Tuple2;

import java.util.List;

/**
 * Created by alex on 9/9/15.
 */
public class Order {


    private static final String EMPTY = "";
    private String accountName = EMPTY;
    private OrderAction orderAction;
    private List<Tuple2> algorithmParameters = Lists.newArrayList();
    private String algorithmStrategy = EMPTY;
    private boolean allOrNone;
    private AuctionStrategy auctionStrategy = AuctionStrategy.INAPPLICABLE;
    private double stopPrice;
    private double basisPoint;
    private int basisPointType;
    private boolean blockOrder;
    private String clearingAccount = EMPTY;
    private String clearingIntent = EMPTY;
    private int clientId;
    private int continuouslyUpdate;
    private double delta;
    private double deltaNeutralAuxPrice;
    private String deltaNeutralClearingAccount = EMPTY;
    private String deltaNeutralClearingIntent = EMPTY;
    private int deltaNeutralContractId;
    private String deltaNeutralOrderType = EMPTY;
    private String deltaNeutralSettlingFirm = EMPTY;
    private String designatedLocation = EMPTY;
    private double discretionaryAmount;
    private int displaySize;
    private boolean electronicTradeOnly;
    private int exemptionCode;
    private String financialAdvisorGroup = EMPTY;
    private String financialAdvisorMethod = EMPTY;
    private String financialAdvisorPercentage = EMPTY;
    private String financialAdvisorProfile = EMPTY;
    private boolean firmQuoteOnly;
    private String goodAfterDateTime = EMPTY;
    private String goodTillDateTime = EMPTY;
    private String hedgeParameter = EMPTY;
    private HedgeType hedgeType = HedgeType.EMPTY;
    private boolean hidden;
    private double limitPrice;
    private int minimumQuantity;
    private double nbboPriceCap;
    private boolean notHeld;
    private String ocaGroupName = EMPTY;
    private OcaType ocaType = OcaType.EMPTY;
    private OpenCloseInstitutional openClose = OpenCloseInstitutional.OPEN;
    private boolean optOutSmartRouting;
    private long id;
    private String orderReference = EMPTY;
    private OrderType orderType;
    private OriginInstitutional origin = OriginInstitutional.CUSTOMER;
    private boolean outsideRegularTradingHours;
    private boolean overridePercentageConstraints;
    private long parentId;
    private double percentageOffset;
    private int permanentId;
    private ReferencePriceType referencePriceType = ReferencePriceType.INAPPLICABLE;
    private Rule80A rule80A = Rule80A.EMPTY;
    private int scaleInitialLevelSize;
    private double scalePriceIncrement;
    private int scaleSubsequentLevelSize;
    private String settlingFirm = EMPTY;
    private ShortSaleSlotInstitutional shortSaleSlot = ShortSaleSlotInstitutional.INAPPLICABLE;
    private List<Tuple2> smartComboRoutingParameters = Lists.newArrayList();
    private double startingPrice;
    private double lowerStockPriceRange;
    private double upperStockPriceRange;
    private double stockReferencePrice;
    private boolean sweepToFill;
    private TIF timeInForce = null;
    private int totalQuantity;
    private double trailingStopPrice;
    private double trailingPercent;
    private boolean transmit;
    private StopTriggerMethod stopTriggerMethod = StopTriggerMethod.DEFAULT;
    private double volatility;
    private VolatilityType volatilityType = VolatilityType.INAPPLICABLE;
    private boolean requestPreTradeInformation;
    private double scalePriceAdjustValue;
    private int scalePriceAdjustInterval;
    private double scaleProfitOffset;
    private boolean scaleAutoReset;
    private int scaleInitPosition;
    private int scaleInitFillQuantity;
    private boolean scaleRandomPercent;
    private List<OrderComboLeg> orderComboLegs = Lists.newArrayList();

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public OrderAction getOrderAction() {
        return orderAction;
    }

    public void setOrderAction(OrderAction orderAction) {
        this.orderAction = orderAction;
    }

    public List<Tuple2> getAlgorithmParameters() {
        return algorithmParameters;
    }

    public void setAlgorithmParameters(List<Tuple2> algorithmParameters) {
        this.algorithmParameters = algorithmParameters;
    }

    public String getAlgorithmStrategy() {
        return algorithmStrategy;
    }

    public void setAlgorithmStrategy(String algorithmStrategy) {
        this.algorithmStrategy = algorithmStrategy;
    }

    public boolean isAllOrNone() {
        return allOrNone;
    }

    public void setAllOrNone(boolean allOrNone) {
        this.allOrNone = allOrNone;
    }

    public AuctionStrategy getAuctionStrategy() {
        return auctionStrategy;
    }

    public void setAuctionStrategy(AuctionStrategy auctionStrategy) {
        this.auctionStrategy = auctionStrategy;
    }

    public double getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(double stopPrice) {
        this.stopPrice = stopPrice;
    }

    public double getBasisPoint() {
        return basisPoint;
    }

    public void setBasisPoint(double basisPoint) {
        this.basisPoint = basisPoint;
    }

    public int getBasisPointType() {
        return basisPointType;
    }

    public void setBasisPointType(int basisPointType) {
        this.basisPointType = basisPointType;
    }

    public boolean isBlockOrder() {
        return blockOrder;
    }

    public void setBlockOrder(boolean blockOrder) {
        this.blockOrder = blockOrder;
    }

    public String getClearingAccount() {
        return clearingAccount;
    }

    public void setClearingAccount(String clearingAccount) {
        this.clearingAccount = clearingAccount;
    }

    public String getClearingIntent() {
        return clearingIntent;
    }

    public void setClearingIntent(String clearingIntent) {
        this.clearingIntent = clearingIntent;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getContinuouslyUpdate() {
        return continuouslyUpdate;
    }

    public void setContinuouslyUpdate(int continuouslyUpdate) {
        this.continuouslyUpdate = continuouslyUpdate;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getDeltaNeutralAuxPrice() {
        return deltaNeutralAuxPrice;
    }

    public void setDeltaNeutralAuxPrice(double deltaNeutralAuxPrice) {
        this.deltaNeutralAuxPrice = deltaNeutralAuxPrice;
    }

    public String getDeltaNeutralClearingAccount() {
        return deltaNeutralClearingAccount;
    }

    public void setDeltaNeutralClearingAccount(String deltaNeutralClearingAccount) {
        this.deltaNeutralClearingAccount = deltaNeutralClearingAccount;
    }

    public String getDeltaNeutralClearingIntent() {
        return deltaNeutralClearingIntent;
    }

    public void setDeltaNeutralClearingIntent(String deltaNeutralClearingIntent) {
        this.deltaNeutralClearingIntent = deltaNeutralClearingIntent;
    }

    public int getDeltaNeutralContractId() {
        return deltaNeutralContractId;
    }

    public void setDeltaNeutralContractId(int deltaNeutralContractId) {
        this.deltaNeutralContractId = deltaNeutralContractId;
    }

    public String getDeltaNeutralOrderType() {
        return deltaNeutralOrderType;
    }

    public void setDeltaNeutralOrderType(String deltaNeutralOrderType) {
        this.deltaNeutralOrderType = deltaNeutralOrderType;
    }

    public String getDeltaNeutralSettlingFirm() {
        return deltaNeutralSettlingFirm;
    }

    public void setDeltaNeutralSettlingFirm(String deltaNeutralSettlingFirm) {
        this.deltaNeutralSettlingFirm = deltaNeutralSettlingFirm;
    }

    public String getDesignatedLocation() {
        return designatedLocation;
    }

    public void setDesignatedLocation(String designatedLocation) {
        this.designatedLocation = designatedLocation;
    }

    public double getDiscretionaryAmount() {
        return discretionaryAmount;
    }

    public void setDiscretionaryAmount(double discretionaryAmount) {
        this.discretionaryAmount = discretionaryAmount;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public boolean isElectronicTradeOnly() {
        return electronicTradeOnly;
    }

    public void setElectronicTradeOnly(boolean electronicTradeOnly) {
        this.electronicTradeOnly = electronicTradeOnly;
    }

    public int getExemptionCode() {
        return exemptionCode;
    }

    public void setExemptionCode(int exemptionCode) {
        this.exemptionCode = exemptionCode;
    }

    public String getFinancialAdvisorGroup() {
        return financialAdvisorGroup;
    }

    public void setFinancialAdvisorGroup(String financialAdvisorGroup) {
        this.financialAdvisorGroup = financialAdvisorGroup;
    }

    public String getFinancialAdvisorMethod() {
        return financialAdvisorMethod;
    }

    public void setFinancialAdvisorMethod(String financialAdvisorMethod) {
        this.financialAdvisorMethod = financialAdvisorMethod;
    }

    public String getFinancialAdvisorPercentage() {
        return financialAdvisorPercentage;
    }

    public void setFinancialAdvisorPercentage(String financialAdvisorPercentage) {
        this.financialAdvisorPercentage = financialAdvisorPercentage;
    }

    public String getFinancialAdvisorProfile() {
        return financialAdvisorProfile;
    }

    public void setFinancialAdvisorProfile(String financialAdvisorProfile) {
        this.financialAdvisorProfile = financialAdvisorProfile;
    }

    public boolean isFirmQuoteOnly() {
        return firmQuoteOnly;
    }

    public void setFirmQuoteOnly(boolean firmQuoteOnly) {
        this.firmQuoteOnly = firmQuoteOnly;
    }

    public String getGoodAfterDateTime() {
        return goodAfterDateTime;
    }

    public void setGoodAfterDateTime(String goodAfterDateTime) {
        this.goodAfterDateTime = goodAfterDateTime;
    }

    public String getGoodTillDateTime() {
        return goodTillDateTime;
    }

    public void setGoodTillDateTime(String goodTillDateTime) {
        this.goodTillDateTime = goodTillDateTime;
    }

    public String getHedgeParameter() {
        return hedgeParameter;
    }

    public void setHedgeParameter(String hedgeParameter) {
        this.hedgeParameter = hedgeParameter;
    }

    public HedgeType getHedgeType() {
        return hedgeType;
    }

    public void setHedgeType(HedgeType hedgeType) {
        this.hedgeType = hedgeType;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(double limitPrice) {
        this.limitPrice = limitPrice;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public double getNbboPriceCap() {
        return nbboPriceCap;
    }

    public void setNbboPriceCap(double nbboPriceCap) {
        this.nbboPriceCap = nbboPriceCap;
    }

    public boolean isNotHeld() {
        return notHeld;
    }

    public void setNotHeld(boolean notHeld) {
        this.notHeld = notHeld;
    }

    public String getOcaGroupName() {
        return ocaGroupName;
    }

    public void setOcaGroupName(String ocaGroupName) {
        this.ocaGroupName = ocaGroupName;
    }

    public OcaType getOcaType() {
        return ocaType;
    }

    public void setOcaType(OcaType ocaType) {
        this.ocaType = ocaType;
    }

    public OpenCloseInstitutional getOpenClose() {
        return openClose;
    }

    public void setOpenClose(OpenCloseInstitutional openClose) {
        this.openClose = openClose;
    }

    public boolean isOptOutSmartRouting() {
        return optOutSmartRouting;
    }

    public void setOptOutSmartRouting(boolean optOutSmartRouting) {
        this.optOutSmartRouting = optOutSmartRouting;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OriginInstitutional getOrigin() {
        return origin;
    }

    public void setOrigin(OriginInstitutional origin) {
        this.origin = origin;
    }

    public boolean isOutsideRegularTradingHours() {
        return outsideRegularTradingHours;
    }

    public void setOutsideRegularTradingHours(boolean outsideRegularTradingHours) {
        this.outsideRegularTradingHours = outsideRegularTradingHours;
    }

    public boolean isOverridePercentageConstraints() {
        return overridePercentageConstraints;
    }

    public void setOverridePercentageConstraints(boolean overridePercentageConstraints) {
        this.overridePercentageConstraints = overridePercentageConstraints;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public double getPercentageOffset() {
        return percentageOffset;
    }

    public void setPercentageOffset(double percentageOffset) {
        this.percentageOffset = percentageOffset;
    }

    public int getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(int permanentId) {
        this.permanentId = permanentId;
    }

    public ReferencePriceType getReferencePriceType() {
        return referencePriceType;
    }

    public void setReferencePriceType(ReferencePriceType referencePriceType) {
        this.referencePriceType = referencePriceType;
    }

    public Rule80A getRule80A() {
        return rule80A;
    }

    public void setRule80A(Rule80A rule80A) {
        this.rule80A = rule80A;
    }

    public int getScaleInitialLevelSize() {
        return scaleInitialLevelSize;
    }

    public void setScaleInitialLevelSize(int scaleInitialLevelSize) {
        this.scaleInitialLevelSize = scaleInitialLevelSize;
    }

    public double getScalePriceIncrement() {
        return scalePriceIncrement;
    }

    public void setScalePriceIncrement(double scalePriceIncrement) {
        this.scalePriceIncrement = scalePriceIncrement;
    }

    public int getScaleSubsequentLevelSize() {
        return scaleSubsequentLevelSize;
    }

    public void setScaleSubsequentLevelSize(int scaleSubsequentLevelSize) {
        this.scaleSubsequentLevelSize = scaleSubsequentLevelSize;
    }

    public String getSettlingFirm() {
        return settlingFirm;
    }

    public void setSettlingFirm(String settlingFirm) {
        this.settlingFirm = settlingFirm;
    }

    public ShortSaleSlotInstitutional getShortSaleSlot() {
        return shortSaleSlot;
    }

    public void setShortSaleSlot(ShortSaleSlotInstitutional shortSaleSlot) {
        this.shortSaleSlot = shortSaleSlot;
    }

    public List<Tuple2> getSmartComboRoutingParameters() {
        return smartComboRoutingParameters;
    }

    public void setSmartComboRoutingParameters(List<Tuple2> smartComboRoutingParameters) {
        this.smartComboRoutingParameters = smartComboRoutingParameters;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getLowerStockPriceRange() {
        return lowerStockPriceRange;
    }

    public void setLowerStockPriceRange(double lowerStockPriceRange) {
        this.lowerStockPriceRange = lowerStockPriceRange;
    }

    public double getUpperStockPriceRange() {
        return upperStockPriceRange;
    }

    public void setUpperStockPriceRange(double upperStockPriceRange) {
        this.upperStockPriceRange = upperStockPriceRange;
    }

    public double getStockReferencePrice() {
        return stockReferencePrice;
    }

    public void setStockReferencePrice(double stockReferencePrice) {
        this.stockReferencePrice = stockReferencePrice;
    }

    public boolean isSweepToFill() {
        return sweepToFill;
    }

    public void setSweepToFill(boolean sweepToFill) {
        this.sweepToFill = sweepToFill;
    }

    public TIF getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TIF timeInForce) {
        this.timeInForce = timeInForce;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTrailingStopPrice() {
        return trailingStopPrice;
    }

    public void setTrailingStopPrice(double trailingStopPrice) {
        this.trailingStopPrice = trailingStopPrice;
    }

    public double getTrailingPercent() {
        return trailingPercent;
    }

    public void setTrailingPercent(double trailingPercent) {
        this.trailingPercent = trailingPercent;
    }

    public boolean isTransmit() {
        return transmit;
    }

    public void setTransmit(boolean transmit) {
        this.transmit = transmit;
    }

    public StopTriggerMethod getStopTriggerMethod() {
        return stopTriggerMethod;
    }

    public void setStopTriggerMethod(StopTriggerMethod stopTriggerMethod) {
        this.stopTriggerMethod = stopTriggerMethod;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    public VolatilityType getVolatilityType() {
        return volatilityType;
    }

    public void setVolatilityType(VolatilityType volatilityType) {
        this.volatilityType = volatilityType;
    }

    public boolean isRequestPreTradeInformation() {
        return requestPreTradeInformation;
    }

    public void setRequestPreTradeInformation(boolean requestPreTradeInformation) {
        this.requestPreTradeInformation = requestPreTradeInformation;
    }

    public double getScalePriceAdjustValue() {
        return scalePriceAdjustValue;
    }

    public void setScalePriceAdjustValue(double scalePriceAdjustValue) {
        this.scalePriceAdjustValue = scalePriceAdjustValue;
    }

    public int getScalePriceAdjustInterval() {
        return scalePriceAdjustInterval;
    }

    public void setScalePriceAdjustInterval(int scalePriceAdjustInterval) {
        this.scalePriceAdjustInterval = scalePriceAdjustInterval;
    }

    public double getScaleProfitOffset() {
        return scaleProfitOffset;
    }

    public void setScaleProfitOffset(double scaleProfitOffset) {
        this.scaleProfitOffset = scaleProfitOffset;
    }

    public boolean isScaleAutoReset() {
        return scaleAutoReset;
    }

    public void setScaleAutoReset(boolean scaleAutoReset) {
        this.scaleAutoReset = scaleAutoReset;
    }

    public int getScaleInitPosition() {
        return scaleInitPosition;
    }

    public void setScaleInitPosition(int scaleInitPosition) {
        this.scaleInitPosition = scaleInitPosition;
    }

    public int getScaleInitFillQuantity() {
        return scaleInitFillQuantity;
    }

    public void setScaleInitFillQuantity(int scaleInitFillQuantity) {
        this.scaleInitFillQuantity = scaleInitFillQuantity;
    }

    public boolean isScaleRandomPercent() {
        return scaleRandomPercent;
    }

    public void setScaleRandomPercent(boolean scaleRandomPercent) {
        this.scaleRandomPercent = scaleRandomPercent;
    }

    public List<OrderComboLeg> getOrderComboLegs() {
        return orderComboLegs;
    }

    public void setOrderComboLegs(List<OrderComboLeg> orderComboLegs) {
        this.orderComboLegs = orderComboLegs;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equal(allOrNone, order.allOrNone) &&
                Objects.equal(stopPrice, order.stopPrice) &&
                Objects.equal(basisPoint, order.basisPoint) &&
                Objects.equal(basisPointType, order.basisPointType) &&
                Objects.equal(blockOrder, order.blockOrder) &&
                Objects.equal(clientId, order.clientId) &&
                Objects.equal(continuouslyUpdate, order.continuouslyUpdate) &&
                Objects.equal(delta, order.delta) &&
                Objects.equal(deltaNeutralAuxPrice, order.deltaNeutralAuxPrice) &&
                Objects.equal(deltaNeutralContractId, order.deltaNeutralContractId) &&
                Objects.equal(discretionaryAmount, order.discretionaryAmount) &&
                Objects.equal(displaySize, order.displaySize) &&
                Objects.equal(electronicTradeOnly, order.electronicTradeOnly) &&
                Objects.equal(exemptionCode, order.exemptionCode) &&
                Objects.equal(firmQuoteOnly, order.firmQuoteOnly) &&
                Objects.equal(hidden, order.hidden) &&
                Objects.equal(limitPrice, order.limitPrice) &&
                Objects.equal(minimumQuantity, order.minimumQuantity) &&
                Objects.equal(nbboPriceCap, order.nbboPriceCap) &&
                Objects.equal(notHeld, order.notHeld) &&
                Objects.equal(optOutSmartRouting, order.optOutSmartRouting) &&
                Objects.equal(id, order.id) &&
                Objects.equal(outsideRegularTradingHours, order.outsideRegularTradingHours) &&
                Objects.equal(overridePercentageConstraints, order.overridePercentageConstraints) &&
                Objects.equal(parentId, order.parentId) &&
                Objects.equal(percentageOffset, order.percentageOffset) &&
                Objects.equal(permanentId, order.permanentId) &&
                Objects.equal(scaleInitialLevelSize, order.scaleInitialLevelSize) &&
                Objects.equal(scalePriceIncrement, order.scalePriceIncrement) &&
                Objects.equal(scaleSubsequentLevelSize, order.scaleSubsequentLevelSize) &&
                Objects.equal(startingPrice, order.startingPrice) &&
                Objects.equal(lowerStockPriceRange, order.lowerStockPriceRange) &&
                Objects.equal(upperStockPriceRange, order.upperStockPriceRange) &&
                Objects.equal(stockReferencePrice, order.stockReferencePrice) &&
                Objects.equal(sweepToFill, order.sweepToFill) &&
                Objects.equal(totalQuantity, order.totalQuantity) &&
                Objects.equal(trailingStopPrice, order.trailingStopPrice) &&
                Objects.equal(trailingPercent, order.trailingPercent) &&
                Objects.equal(transmit, order.transmit) &&
                Objects.equal(volatility, order.volatility) &&
                Objects.equal(requestPreTradeInformation, order.requestPreTradeInformation) &&
                Objects.equal(scalePriceAdjustValue, order.scalePriceAdjustValue) &&
                Objects.equal(scalePriceAdjustInterval, order.scalePriceAdjustInterval) &&
                Objects.equal(scaleProfitOffset, order.scaleProfitOffset) &&
                Objects.equal(scaleAutoReset, order.scaleAutoReset) &&
                Objects.equal(scaleInitPosition, order.scaleInitPosition) &&
                Objects.equal(scaleInitFillQuantity, order.scaleInitFillQuantity) &&
                Objects.equal(scaleRandomPercent, order.scaleRandomPercent) &&
                Objects.equal(accountName, order.accountName) &&
                Objects.equal(orderAction, order.orderAction) &&
                Objects.equal(algorithmParameters, order.algorithmParameters) &&
                Objects.equal(algorithmStrategy, order.algorithmStrategy) &&
                Objects.equal(auctionStrategy, order.auctionStrategy) &&
                Objects.equal(clearingAccount, order.clearingAccount) &&
                Objects.equal(clearingIntent, order.clearingIntent) &&
                Objects.equal(deltaNeutralClearingAccount, order.deltaNeutralClearingAccount) &&
                Objects.equal(deltaNeutralClearingIntent, order.deltaNeutralClearingIntent) &&
                Objects.equal(deltaNeutralOrderType, order.deltaNeutralOrderType) &&
                Objects.equal(deltaNeutralSettlingFirm, order.deltaNeutralSettlingFirm) &&
                Objects.equal(designatedLocation, order.designatedLocation) &&
                Objects.equal(financialAdvisorGroup, order.financialAdvisorGroup) &&
                Objects.equal(financialAdvisorMethod, order.financialAdvisorMethod) &&
                Objects.equal(financialAdvisorPercentage, order.financialAdvisorPercentage) &&
                Objects.equal(financialAdvisorProfile, order.financialAdvisorProfile) &&
                Objects.equal(goodAfterDateTime, order.goodAfterDateTime) &&
                Objects.equal(goodTillDateTime, order.goodTillDateTime) &&
                Objects.equal(hedgeParameter, order.hedgeParameter) &&
                Objects.equal(hedgeType, order.hedgeType) &&
                Objects.equal(ocaGroupName, order.ocaGroupName) &&
                Objects.equal(ocaType, order.ocaType) &&
                Objects.equal(openClose, order.openClose) &&
                Objects.equal(orderReference, order.orderReference) &&
                Objects.equal(orderType, order.orderType) &&
                Objects.equal(origin, order.origin) &&
                Objects.equal(referencePriceType, order.referencePriceType) &&
                Objects.equal(rule80A, order.rule80A) &&
                Objects.equal(settlingFirm, order.settlingFirm) &&
                Objects.equal(shortSaleSlot, order.shortSaleSlot) &&
                Objects.equal(smartComboRoutingParameters, order.smartComboRoutingParameters) &&
                Objects.equal(timeInForce, order.timeInForce) &&
                Objects.equal(stopTriggerMethod, order.stopTriggerMethod) &&
                Objects.equal(volatilityType, order.volatilityType) &&
                Objects.equal(orderComboLegs, order.orderComboLegs);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountName, orderAction, algorithmParameters, algorithmStrategy, allOrNone, auctionStrategy, stopPrice, basisPoint, basisPointType, blockOrder, clearingAccount, clearingIntent, clientId, continuouslyUpdate, delta, deltaNeutralAuxPrice, deltaNeutralClearingAccount, deltaNeutralClearingIntent, deltaNeutralContractId, deltaNeutralOrderType, deltaNeutralSettlingFirm, designatedLocation, discretionaryAmount, displaySize, electronicTradeOnly, exemptionCode, financialAdvisorGroup, financialAdvisorMethod, financialAdvisorPercentage, financialAdvisorProfile, firmQuoteOnly, goodAfterDateTime, goodTillDateTime, hedgeParameter, hedgeType, hidden, limitPrice, minimumQuantity, nbboPriceCap, notHeld, ocaGroupName, ocaType, openClose, optOutSmartRouting, id, orderReference, orderType, origin, outsideRegularTradingHours, overridePercentageConstraints, parentId, percentageOffset, permanentId, referencePriceType, rule80A, scaleInitialLevelSize, scalePriceIncrement, scaleSubsequentLevelSize, settlingFirm, shortSaleSlot, smartComboRoutingParameters, startingPrice, lowerStockPriceRange, upperStockPriceRange, stockReferencePrice, sweepToFill, timeInForce, totalQuantity, trailingStopPrice, trailingPercent, transmit, stopTriggerMethod, volatility, volatilityType, requestPreTradeInformation, scalePriceAdjustValue, scalePriceAdjustInterval, scaleProfitOffset, scaleAutoReset, scaleInitPosition, scaleInitFillQuantity, scaleRandomPercent, orderComboLegs);
    }

    @Override
    public String toString() {
        return "Order{" +
                "accountName='" + accountName + '\'' +
                ", action=" + orderAction +
                ", algorithmParameters=" + algorithmParameters +
                ", algorithmStrategy='" + algorithmStrategy + '\'' +
                ", allOrNone=" + allOrNone +
                ", auctionStrategy=" + auctionStrategy +
                ", stopPrice=" + stopPrice +
                ", basisPoint=" + basisPoint +
                ", basisPointType=" + basisPointType +
                ", blockOrder=" + blockOrder +
                ", clearingAccount='" + clearingAccount + '\'' +
                ", clearingIntent='" + clearingIntent + '\'' +
                ", clientId=" + clientId +
                ", continuouslyUpdate=" + continuouslyUpdate +
                ", delta=" + delta +
                ", deltaNeutralAuxPrice=" + deltaNeutralAuxPrice +
                ", deltaNeutralClearingAccount='" + deltaNeutralClearingAccount + '\'' +
                ", deltaNeutralClearingIntent='" + deltaNeutralClearingIntent + '\'' +
                ", deltaNeutralContractId=" + deltaNeutralContractId +
                ", deltaNeutralOrderType='" + deltaNeutralOrderType + '\'' +
                ", deltaNeutralSettlingFirm='" + deltaNeutralSettlingFirm + '\'' +
                ", designatedLocation='" + designatedLocation + '\'' +
                ", discretionaryAmount=" + discretionaryAmount +
                ", displaySize=" + displaySize +
                ", electronicTradeOnly=" + electronicTradeOnly +
                ", exemptionCode=" + exemptionCode +
                ", financialAdvisorGroup='" + financialAdvisorGroup + '\'' +
                ", financialAdvisorMethod='" + financialAdvisorMethod + '\'' +
                ", financialAdvisorPercentage='" + financialAdvisorPercentage + '\'' +
                ", financialAdvisorProfile='" + financialAdvisorProfile + '\'' +
                ", firmQuoteOnly=" + firmQuoteOnly +
                ", goodAfterDateTime='" + goodAfterDateTime + '\'' +
                ", goodTillDateTime='" + goodTillDateTime + '\'' +
                ", hedgeParameter='" + hedgeParameter + '\'' +
                ", hedgeType=" + hedgeType +
                ", hidden=" + hidden +
                ", limitPrice=" + limitPrice +
                ", minimumQuantity=" + minimumQuantity +
                ", nbboPriceCap=" + nbboPriceCap +
                ", notHeld=" + notHeld +
                ", ocaGroupName='" + ocaGroupName + '\'' +
                ", ocaType=" + ocaType +
                ", openClose=" + openClose +
                ", optOutSmartRouting=" + optOutSmartRouting +
                ", id=" + id +
                ", orderReference='" + orderReference + '\'' +
                ", orderType=" + orderType +
                ", origin=" + origin +
                ", outsideRegularTradingHours=" + outsideRegularTradingHours +
                ", overridePercentageConstraints=" + overridePercentageConstraints +
                ", parentId=" + parentId +
                ", percentageOffset=" + percentageOffset +
                ", permanentId=" + permanentId +
                ", referencePriceType=" + referencePriceType +
                ", rule80A=" + rule80A +
                ", scaleInitialLevelSize=" + scaleInitialLevelSize +
                ", scalePriceIncrement=" + scalePriceIncrement +
                ", scaleSubsequentLevelSize=" + scaleSubsequentLevelSize +
                ", settlingFirm='" + settlingFirm + '\'' +
                ", shortSaleSlot=" + shortSaleSlot +
                ", smartComboRoutingParameters=" + smartComboRoutingParameters +
                ", startingPrice=" + startingPrice +
                ", lowerStockPriceRange=" + lowerStockPriceRange +
                ", upperStockPriceRange=" + upperStockPriceRange +
                ", stockReferencePrice=" + stockReferencePrice +
                ", sweepToFill=" + sweepToFill +
                ", timeInForce=" + timeInForce +
                ", totalQuantity=" + totalQuantity +
                ", trailingStopPrice=" + trailingStopPrice +
                ", trailingPercent=" + trailingPercent +
                ", transmit=" + transmit +
                ", stopTriggerMethod=" + stopTriggerMethod +
                ", volatility=" + volatility +
                ", volatilityType=" + volatilityType +
                ", requestPreTradeInformation=" + requestPreTradeInformation +
                ", scalePriceAdjustValue=" + scalePriceAdjustValue +
                ", scalePriceAdjustInterval=" + scalePriceAdjustInterval +
                ", scaleProfitOffset=" + scaleProfitOffset +
                ", scaleAutoReset=" + scaleAutoReset +
                ", scaleInitPosition=" + scaleInitPosition +
                ", scaleInitFillQuantity=" + scaleInitFillQuantity +
                ", scaleRandomPercent=" + scaleRandomPercent +
                ", orderComboLegs=" + orderComboLegs +
                '}';
    }
}
