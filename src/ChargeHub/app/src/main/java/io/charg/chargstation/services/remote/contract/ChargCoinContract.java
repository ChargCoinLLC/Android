package io.charg.chargstation.services.remote.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class ChargCoinContract extends Contract {
    private static final String BINARY = "60606040526a4a723dc6b40b8a9a00000060005560408051908101604052600381527f4348470000000000000000000000000000000000000000000000000000000000602082015260049080516200005c929160200190620001e5565b5060408051908101604052600a81527f436861726720436f696e0000000000000000000000000000000000000000000060208201526005908051620000a6929160200190620001e5565b5060408051908101604052600381527f434847000000000000000000000000000000000000000000000000000000000060208201526006908051620000f0929160200190620001e5565b50601260075560088054600160a060020a03191673482efd447be88748e7625e2b7c522c388970b7901790556103206010556014805460ff19169055670de0b6b3a76400006015556902a5a058fc295ed0000060165560006017556a4a723dc6b40b8a9a0000006018556a084595161401484a0000006019556a0771d2fa45345aa9000000601a556a3913517ebd3c0c65000000601b556a01a784379d99db42000000601c55601d805462ffffff191690553415620001ae57600080fd5b60038054600160a060020a03191633600160a060020a0316908117909155601854600091825260016020526040909120556200028a565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200022857805160ff191683800117855562000258565b8280016001018555821562000258579182015b82811115620002585782518255916020019190600101906200023b565b50620002669291506200026a565b5090565b6200028791905b8082111562000266576000815560010162000271565b90565b611d14806200029a6000396000f3006060604052600436106102195763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305540534811461028257806306fdde03146102a3578063095ea7b31461032d57806314befc701461036357806318160ddd1461038257806323548b8b146103a7578063236a8d9d146103ba57806323b872dd146103d357806329bcb186146103fb5780632edcedc61461041d578063313ce56714610481578063360f6b211461049457806337ba682d146104b35780633b5adcef146104c65780633fa615b0146104e55780634783c35b146104f85780635a3b7e42146105275780636247c38f1461053a578063626263c5146105505780636276b368146105665780636482c5351461058557806365857a5e146105a457806366188463146105c657806370a08231146105e8578063788102ff146106075780637f86033014610626578063851f9e201461063c5780638da5cb5b1461065b57806392acb4d61461066e57806395d89b41146106a557806398d5fdca146106b85780639aa84b0b146106cb578063a9059cbb146106ea578063adaf8c791461070c578063b91816111461072e578063c4ccf6ea1461074d578063c75363b614610763578063cc92bad41461053a578063cedbbeee14610776578063d73dd6231461078a578063dd62ed3e146107ac578063e7bb5233146107d1578063f2fde38b14610808578063fddf0fc014610827575b600034151561022757600080fd5b600260145460ff16600281111561023a57fe5b141561024557600080fd5b61024d61083a565b9050600160145460ff16600281111561026257fe5b14156102765761027133610958565b61027f565b61027f81610b13565b50005b341561028d57600080fd5b6102a1600160a060020a0360043516610b58565b005b34156102ae57600080fd5b6102b6610b95565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156102f25780820151838201526020016102da565b50505050905090810190601f16801561031f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561033857600080fd5b61034f600160a060020a0360043516602435610c33565b604051901515815260200160405180910390f35b341561036e57600080fd5b6102a1600160a060020a0360043516610c9f565b341561038d57600080fd5b610395610de4565b60405190815260200160405180910390f35b34156103b257600080fd5b610395610dea565b34156103c557600080fd5b6102a1600435602435610df0565b34156103de57600080fd5b61034f600160a060020a0360043581169060243516604435610e4c565b341561040657600080fd5b6102a1600160a060020a0360043516602435610f76565b341561042857600080fd5b61043c600160a060020a0360043516610ff9565b604051600160a060020a039096168652602086019490945260408086019390935260608501919091521515608084015260a083019190915260c0909101905180910390f35b341561048c57600080fd5b61039561103e565b341561049f57600080fd5b61043c600160a060020a0360043516611044565b34156104be57600080fd5b610395611089565b34156104d157600080fd5b610395600160a060020a0360043516611091565b34156104f057600080fd5b6103956110a3565b341561050357600080fd5b61050b6110a9565b604051600160a060020a03909116815260200160405180910390f35b341561053257600080fd5b6102b66110b8565b341561054557600080fd5b6102a1600435611123565b341561055b57600080fd5b61039560043561113e565b341561057157600080fd5b610395600160a060020a0360043516611195565b341561059057600080fd5b610395600160a060020a03600435166111a7565b34156105af57600080fd5b6102a1600160a060020a03600435166024356111b9565b34156105d157600080fd5b61034f600160a060020a0360043516602435611392565b34156105f357600080fd5b610395600160a060020a036004351661148c565b341561061257600080fd5b610395600160a060020a03600435166114a7565b341561063157600080fd5b6102a16004356114b9565b341561064757600080fd5b6102a1600160a060020a036004351661161c565b341561066657600080fd5b61050b611761565b341561067957600080fd5b61068d600160a060020a0360043516611770565b60405191825260208201526040908101905180910390f35b34156106b057600080fd5b6102b6611789565b34156106c357600080fd5b6103956117f4565b34156106d657600080fd5b6102a1600160a060020a03600435166117fa565b34156106f557600080fd5b61034f600160a060020a036004351660243561182f565b341561071757600080fd5b6102a1600160a060020a0360043516602435611905565b341561073957600080fd5b610395600160a060020a0360043516611ad8565b341561075857600080fd5b610395600435611aea565b341561076e57600080fd5b610395611b64565b6102a1600160a060020a0360043516610958565b341561079557600080fd5b61034f600160a060020a0360043516602435611b6c565b34156107b757600080fd5b610395600160a060020a0360043581169060243516611c10565b34156107dc57600080fd5b6107e4611c3b565b604051808260028111156107f457fe5b60ff16815260200191505060405180910390f35b341561081357600080fd5b6102a1600160a060020a0360043516611c44565b341561083257600080fd5b610395611c96565b6000601654601754101580156108615750600260145460ff16600281111561085e57fe5b14155b156108b657601480546002919060ff19166001835b02179055507f9145a7fd7de2aa5b50a289cf5dd2e2d100aa067911e49855b88f94b5a196f04b4360405190815260200160405180910390a1506001610955565b635a497a0042106108d557601480546002919060ff1916600183610876565b635a242bdd42101580156108ec5750635a497a0042105b1561095157600160145460ff16600281111561090457fe5b14610951576014805460ff191660011790557f712173de1d50109191e0d0671c67415bf3d44508558069796106054c5600d5014360405190815260200160405180910390a1506001610955565b5060005b90565b6017546016543491829160009182910383111561097e5760175460165403925082840391505b60155483601754011180156109965750601754601554115b156109cf577f71bd1f47064193be653e360173639170d33d2cfe47bf52a3de621ca4040e23584360405190815260200160405180910390a15b60165483601754011480156109e75750601654601754105b15610a20577f38caa2c61728c18eb71cbd06d1915e4164ffe51c69a09b68d78be1f125a5dea74360405190815260200160405180910390a15b600160a060020a0385166000908152601160205260409020541515610a72576012805460009081526013602052604090208054600160a060020a031916600160a060020a038816179055805460010190555b600160a060020a03851660009081526011602052604090208054840190556017805484019055610aa18361113e565b90506000811115610ad857610ab68582610f76565b600160a060020a03851660009081526011602052604090206001018054820190555b600854600160a060020a03163480156108fc0290604051600060405180830381858888f193505050501515610b0c57600080fd5b5050505050565b8015610b5057600160a060020a0333163480156108fc0290604051600060405180830381858888f193505050501515610b4b57600080fd5b610b55565b600080fd5b50565b60035433600160a060020a03908116911614610b7357600080fd5b60088054600160a060020a031916600160a060020a0392909216919091179055565b60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c2b5780601f10610c0057610100808354040283529160200191610c2b565b820191906000526020600020905b815481529060010190602001808311610c0e57829003601f168201915b505050505081565b600160a060020a03338116600081815260026020908152604080832094871680845294909152808220859055909291907f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259085905190815260200160405180910390a350600192915050565b600160a060020a0333166000908152600d602052604081206004015460ff161515610cc957600080fd5b50600160a060020a0333166000908152600d6020526040902060038101546001820154600590920154429290920302908111610d055780610d22565b600160a060020a0333166000908152600d60205260409020600501545b600160a060020a038084166000908152600160209081526040808320805486019055339093168252600f9052908120805483900390819055919250901115610d9557600160a060020a0333166000908152600f602081815260408084208054600184529185208054909201909155919052555b5050600160a060020a0333166000908152600d602052604081208054600160a060020a031916815560018101829055600281018290556003810182905560048101805460ff1916905560050155565b60185481565b60165481565b600160a060020a03331660009081526009602052604090205460011415610e1657600080fd5b600160a060020a0333166000908152600a6020908152604080832094909455600b81528382209290925560099091522060019055565b600080600160a060020a0384161515610e6457600080fd5b50600160a060020a03808516600081815260026020908152604080832033909516835293815283822054928252600190529190912054610eaa908463ffffffff611c9c16565b600160a060020a038087166000908152600160205260408082209390935590861681522054610edf908463ffffffff611cae16565b600160a060020a038516600090815260016020526040902055610f08818463ffffffff611c9c16565b600160a060020a03808716600081815260026020908152604080832033861684529091529081902093909355908616917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9086905190815260200160405180910390a3506001949350505050565b600354600160a060020a0316600090815260016020526040902054610fa1908263ffffffff611c9c16565b600354600160a060020a039081166000908152600160205260408082209390935590841681522054610fd9908263ffffffff611cae16565b600160a060020a0390921660009081526001602052604090209190915550565b600d60205260009081526040902080546001820154600283015460038401546004850154600590950154600160a060020a039094169492939192909160ff9091169086565b60075481565b600c60205260009081526040902080546001820154600283015460038401546004850154600590950154600160a060020a039094169492939192909160ff9091169086565b635a497a0081565b600e6020526000908152604090205481565b60155481565b600854600160a060020a031681565b60048054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c2b5780601f10610c0057610100808354040283529160200191610c2b565b600160a060020a0333166000908152600a6020526040902055565b600080600061115b61114e6117f4565b859063ffffffff611cc416565b915060009050600060175411156111825760165460175460640281151561117e57fe5b0490505b61118b82611aea565b9091019392505050565b600a6020526000908152604090205481565b600b6020526000908152604090205481565b600160a060020a038216600090815260096020526040812054819015156111df57600080fd5b600160a060020a0333166000908152600d602052604090206004015460ff161561120857600080fd5b600160a060020a0333166000908152600160205260409020548190101561122e57600080fd5b428084019250821161123f57600080fd5b50600160a060020a0383166000908152600b60205260409081902054428303029060c090519081016040908152600160a060020a03808716808452426020808601919091528385018790526000918252600b81528382205460608601526001608086015260a08501869052339092168152600d9091522081518154600160a060020a031916600160a060020a0391909116178155602082015181600101556040820151816002015560608201518160030155608082015160048201805460ff191691151591909117905560a082015160059091015550600160a060020a03331660009081526001602052604090205461133e908263ffffffff611c9c16565b600160a060020a033316600090815260016020908152604080832093909355600f90522054611373908263ffffffff611cae16565b600160a060020a0333166000908152600f602052604090205550505050565b600160a060020a033381166000908152600260209081526040808320938616835292905290812054808311156113ef57600160a060020a033381166000908152600260209081526040808320938816835292905290812055611426565b6113ff818463ffffffff611c9c16565b600160a060020a033381166000908152600260209081526040808320938916835292905220555b600160a060020a0333811660008181526002602090815260408083209489168084529490915290819020547f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925915190815260200160405180910390a35060019392505050565b600160a060020a031660009081526001602052604090205490565b600f6020526000908152604090205481565b6003546000908190819033600160a060020a039081169116146114db57600080fd5b600260145460ff1660028111156114ee57fe5b14156114f957600080fd5b6015546017541061150957600080fd5b5060005b8381101561161657601e54600090815260136020526040902054600160a060020a0316925082151561153e57611616565b600160a060020a0383166000908152601f602052604090205460ff16151561160457600160a060020a038316600081815260116020908152604080832054601f8352818420805460ff1916600190811790915590925280832092909255935083156108fc0290849051600060405180830381858888f193505050501515611604577fdb623bd5ad9b688a8d252706b5f3b2849545e7c47f1a9be77f95b198445a67d38383604051600160a060020a03909216825260208201526040908101905180910390a15b601e805460019081019091550161150d565b50505050565b600160a060020a0333166000908152600c602052604081206004015460ff16151561164657600080fd5b50600160a060020a0333166000908152600c6020526040902060038101546001820154600590920154429290920302908111611682578061169f565b600160a060020a0333166000908152600c60205260409020600501545b600160a060020a038084166000908152600160209081526040808320805486019055339093168252600e905290812080548390039081905591925090111561171257600160a060020a0333166000908152600e602081815260408084208054600184529185208054909201909155919052555b5050600160a060020a0333166000908152600c602052604081208054600160a060020a031916815560018101829055600281018290556003810182905560048101805460ff1916905560050155565b600354600160a060020a031681565b6011602052600090815260409020805460019091015482565b60068054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c2b5780601f10610c0057610100808354040283529160200191610c2b565b60105490565b60035433600160a060020a0390811691161461181557600080fd5b600160a060020a0316600090815260096020526040812055565b6000600160a060020a038316151561184657600080fd5b600160a060020a03331660009081526001602052604090205461186f908363ffffffff611c9c16565b600160a060020a0333811660009081526001602052604080822093909355908516815220546118a4908363ffffffff611cae16565b600160a060020a0380851660008181526001602052604090819020939093559133909116907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9085905190815260200160405180910390a350600192915050565b600160a060020a0382166000908152600960205260408120548190151561192b57600080fd5b600160a060020a0333166000908152600c602052604090206004015460ff161561195457600080fd5b428084019250821161196557600080fd5b50600160a060020a038084166000908152600a6020908152604080832054339094168352600190915290205442830390910290819010156119a557600080fd5b60c06040519081016040908152600160a060020a03808716808452426020808601919091528385018790526000918252600a81528382205460608601526001608086015260a08501869052339092168152600c9091522081518154600160a060020a031916600160a060020a0391909116178155602082015181600101556040820151816002015560608201518160030155608082015160048201805460ff191691151591909117905560a082015160059091015550600160a060020a033316600090815260016020526040902054611a84908263ffffffff611c9c16565b600160a060020a033316600090815260016020908152604080832093909355600e90522054611ab9908263ffffffff611cae16565b600160a060020a0333166000908152600e602052604090205550505050565b60096020526000908152604090205481565b6000806127108310611afd575081611b5e565b6113888310611b15576064603c84025b049050611b5e565b6103e88310611b29576064601e8402611b0d565b6101f48310611b3d576064600a8402611b0d565b60648310611b5057606460058402611b0d565b600a8310611b5e5750606482045b92915050565b635a242bdd81565b600160a060020a033381166000908152600260209081526040808320938616835292905290812054611ba4908363ffffffff611cae16565b600160a060020a0333811660008181526002602090815260408083209489168084529490915290819020849055919290917f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591905190815260200160405180910390a350600192915050565b600160a060020a03918216600090815260026020908152604080832093909416825291909152205490565b60145460ff1681565b60035433600160a060020a03908116911614611c5f57600080fd5b600160a060020a0381161515611c7457600080fd5b60038054600160a060020a031916600160a060020a0392909216919091179055565b60175481565b600082821115611ca857fe5b50900390565b600082820183811015611cbd57fe5b9392505050565b6000828202831580611ce05750828482811515611cdd57fe5b04145b1515611cbd57fe00a165627a7a723058203c306ff8c499c2fd22e4608954ca8d39ef60bd2e19ed98c8b57ac07efa5a71ad0029";

    protected ChargCoinContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChargCoinContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<CrowdsaleStartedEventResponse> getCrowdsaleStartedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("CrowdsaleStarted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CrowdsaleStartedEventResponse> responses = new ArrayList<CrowdsaleStartedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CrowdsaleStartedEventResponse typedResponse = new CrowdsaleStartedEventResponse();
            typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CrowdsaleStartedEventResponse> crowdsaleStartedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("CrowdsaleStarted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CrowdsaleStartedEventResponse>() {
            @Override
            public CrowdsaleStartedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CrowdsaleStartedEventResponse typedResponse = new CrowdsaleStartedEventResponse();
                typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<CrowdsaleEndedEventResponse> getCrowdsaleEndedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("CrowdsaleEnded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CrowdsaleEndedEventResponse> responses = new ArrayList<CrowdsaleEndedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CrowdsaleEndedEventResponse typedResponse = new CrowdsaleEndedEventResponse();
            typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CrowdsaleEndedEventResponse> crowdsaleEndedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("CrowdsaleEnded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CrowdsaleEndedEventResponse>() {
            @Override
            public CrowdsaleEndedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CrowdsaleEndedEventResponse typedResponse = new CrowdsaleEndedEventResponse();
                typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ErrorSendingETHEventResponse> getErrorSendingETHEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ErrorSendingETH", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ErrorSendingETHEventResponse> responses = new ArrayList<ErrorSendingETHEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ErrorSendingETHEventResponse typedResponse = new ErrorSendingETHEventResponse();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ErrorSendingETHEventResponse> errorSendingETHEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ErrorSendingETH", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorSendingETHEventResponse>() {
            @Override
            public ErrorSendingETHEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ErrorSendingETHEventResponse typedResponse = new ErrorSendingETHEventResponse();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<MinCapReachedEventResponse> getMinCapReachedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MinCapReached", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MinCapReachedEventResponse> responses = new ArrayList<MinCapReachedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MinCapReachedEventResponse typedResponse = new MinCapReachedEventResponse();
            typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MinCapReachedEventResponse> minCapReachedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MinCapReached", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MinCapReachedEventResponse>() {
            @Override
            public MinCapReachedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MinCapReachedEventResponse typedResponse = new MinCapReachedEventResponse();
                typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<MaxCapReachedEventResponse> getMaxCapReachedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MaxCapReached", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MaxCapReachedEventResponse> responses = new ArrayList<MaxCapReachedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MaxCapReachedEventResponse typedResponse = new MaxCapReachedEventResponse();
            typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MaxCapReachedEventResponse> maxCapReachedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MaxCapReached", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MaxCapReachedEventResponse>() {
            @Override
            public MaxCapReachedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MaxCapReachedEventResponse typedResponse = new MaxCapReachedEventResponse();
                typedResponse.blockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> setMultisigAddress(String _newAddress) {
        Function function = new Function(
                "setMultisigAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> name() {
        Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> parkingOff(String node) {
        Function function = new Function(
                "parkingOff", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(node)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> maxCap() {
        Function function = new Function("maxCap", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> registerNode(BigInteger chargingRate, BigInteger parkingRate) {
        Function function = new Function(
                "registerNode", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(chargingRate), 
                new org.web3j.abi.datatypes.generated.Uint256(parkingRate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        Function function = new Function(
                "transferFrom", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferToContributor(String _to, BigInteger _value) {
        Function function = new Function(
                "transferToContributor", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>> parkingSwitches(String param0) {
        final Function function = new Function("parkingSwitches", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>>(
                new Callable<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>>() {
                    @Override
                    public Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>> chargingSwitches(String param0) {
        final Function function = new Function("chargingSwitches", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>>(
                new Callable<Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>>() {
                    @Override
                    public Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<String, BigInteger, BigInteger, BigInteger, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> END_TIME() {
        Function function = new Function("END_TIME", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> reservedFundsCharging(String param0) {
        Function function = new Function("reservedFundsCharging", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> minCap() {
        Function function = new Function("minCap", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> multisig() {
        Function function = new Function("multisig", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> standard() {
        Function function = new Function("standard", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> updateChargingRate(BigInteger rate) {
        Function function = new Function(
                "updateChargingRate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(rate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> calculateEthToChargcoin(BigInteger _eth) {
        Function function = new Function("calculateEthToChargcoin", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eth)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> rateOfCharging(String param0) {
        Function function = new Function("rateOfCharging", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> rateOfParking(String param0) {
        Function function = new Function("rateOfParking", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> parkingOn(String node, BigInteger time) {
        Function function = new Function(
                "parkingOn", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(node), 
                new org.web3j.abi.datatypes.generated.Uint256(time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> decreaseApproval(String _spender, BigInteger _subtractedValue) {
        Function function = new Function(
                "decreaseApproval", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> reservedFundsParking(String param0) {
        Function function = new Function("reservedFundsParking", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> batchReturnEthIfFailed(BigInteger _numberOfReturns) {
        Function function = new Function(
                "batchReturnEthIfFailed", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_numberOfReturns)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> chargeOff(String node) {
        Function function = new Function(
                "chargeOff",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(node)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> contributorList(String param0) {
        final Function function = new Function("contributorList", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getPrice() {
        Function function = new Function("getPrice", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> blockNode(String node) {
        Function function = new Function(
                "blockNode", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(node)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> chargeOn(String node, BigInteger time) {
        Function function = new Function(
                "chargeOn",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(node), 
                new org.web3j.abi.datatypes.generated.Uint256(time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> authorized(String param0) {
        Function function = new Function("authorized", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getAmountBonus(BigInteger tokens) {
        Function function = new Function("getAmountBonus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokens)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> BEGIN_TIME() {
        Function function = new Function("BEGIN_TIME", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> updateParkingRate(BigInteger rate) {
        Function function = new Function(
                "updateParkingRate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(rate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createTokens(String _contributor, BigInteger weiValue) {
        Function function = new Function(
                "createTokens", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_contributor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> increaseApproval(String _spender, BigInteger _addedValue) {
        Function function = new Function(
                "increaseApproval", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> crowdsaleState() {
        Function function = new Function("crowdsaleState", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> ethRaised() {
        Function function = new Function("ethRaised", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<ChargCoinContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargCoinContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ChargCoinContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargCoinContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static ChargCoinContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargCoinContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ChargCoinContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargCoinContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class CrowdsaleStartedEventResponse {
        public BigInteger blockNumber;
    }

    public static class CrowdsaleEndedEventResponse {
        public BigInteger blockNumber;
    }

    public static class ErrorSendingETHEventResponse {
        public String to;

        public BigInteger amount;
    }

    public static class MinCapReachedEventResponse {
        public BigInteger blockNumber;
    }

    public static class MaxCapReachedEventResponse {
        public BigInteger blockNumber;
    }

    public static class ApprovalEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
