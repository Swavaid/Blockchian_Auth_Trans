package smartcontract.Broadcast;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.4.0.
 */
public class Broadcast extends Contract {
    private static final String BINARY = "{\n"
            + "\t\"generatedSources\": [],\n"
            + "\t\"linkReferences\": {},\n"
            + "\t\"object\": \"608060405234801561001057600080fd5b50610442806100206000396000f3fe60806040526004361061001e5760003560e01c806337fa9e7a14610023575b600080fd5b61003d60048036038101906100389190610183565b610053565b60405161004a9190610286565b60405180910390f35b60607f5118382634e12d76f909512fae45e0a3b880e1d01763c6504aee0596146d5ddb826040516100849190610286565b60405180910390a1819050919050565b60006100a76100a2846102d9565b6102a8565b9050808382526020820190508260005b858110156100e757813585016100cd8882610159565b8452602084019350602083019250506001810190506100b7565b5050509392505050565b60006101046100ff84610305565b6102a8565b90508281526020810184848401111561011c57600080fd5b61012784828561038a565b509392505050565b600082601f83011261014057600080fd5b8135610150848260208601610094565b91505092915050565b600082601f83011261016a57600080fd5b813561017a8482602086016100f1565b91505092915050565b60006020828403121561019557600080fd5b600082013567ffffffffffffffff8111156101af57600080fd5b6101bb8482850161012f565b91505092915050565b60006101d0838361024d565b905092915050565b60006101e382610345565b6101ed8185610368565b9350836020820285016101ff85610335565b8060005b8581101561023b578484038952815161021c85826101c4565b94506102278361035b565b925060208a01995050600181019050610203565b50829750879550505050505092915050565b600061025882610350565b6102628185610379565b9350610272818560208601610399565b61027b816103fb565b840191505092915050565b600060208201905081810360008301526102a081846101d8565b905092915050565b6000604051905081810181811067ffffffffffffffff821117156102cf576102ce6103cc565b5b8060405250919050565b600067ffffffffffffffff8211156102f4576102f36103cc565b5b602082029050602081019050919050565b600067ffffffffffffffff8211156103205761031f6103cc565b5b601f19601f8301169050602081019050919050565b6000819050602082019050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b600082825260208201905092915050565b600082825260208201905092915050565b82818337600083830152505050565b60005b838110156103b757808201518184015260208101905061039c565b838111156103c6576000848401525b50505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6000601f19601f830116905091905056fea26469706673582212206ac92485852808de0bd8f2c8a8c39dd9105626ddac6834c4433dfd0586f918ac64736f6c63430008000033\",\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x442 DUP1 PUSH2 0x20 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE PUSH1 0x4 CALLDATASIZE LT PUSH2 0x1E JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x37FA9E7A EQ PUSH2 0x23 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x3D PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x38 SWAP2 SWAP1 PUSH2 0x183 JUMP JUMPDEST PUSH2 0x53 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x4A SWAP2 SWAP1 PUSH2 0x286 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0x60 PUSH32 0x5118382634E12D76F909512FAE45E0A3B880E1D01763C6504AEE0596146D5DDB DUP3 PUSH1 0x40 MLOAD PUSH2 0x84 SWAP2 SWAP1 PUSH2 0x286 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG1 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xA7 PUSH2 0xA2 DUP5 PUSH2 0x2D9 JUMP JUMPDEST PUSH2 0x2A8 JUMP JUMPDEST SWAP1 POP DUP1 DUP4 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP DUP3 PUSH1 0x0 JUMPDEST DUP6 DUP2 LT ISZERO PUSH2 0xE7 JUMPI DUP2 CALLDATALOAD DUP6 ADD PUSH2 0xCD DUP9 DUP3 PUSH2 0x159 JUMP JUMPDEST DUP5 MSTORE PUSH1 0x20 DUP5 ADD SWAP4 POP PUSH1 0x20 DUP4 ADD SWAP3 POP POP PUSH1 0x1 DUP2 ADD SWAP1 POP PUSH2 0xB7 JUMP JUMPDEST POP POP POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x104 PUSH2 0xFF DUP5 PUSH2 0x305 JUMP JUMPDEST PUSH2 0x2A8 JUMP JUMPDEST SWAP1 POP DUP3 DUP2 MSTORE PUSH1 0x20 DUP2 ADD DUP5 DUP5 DUP5 ADD GT ISZERO PUSH2 0x11C JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x127 DUP5 DUP3 DUP6 PUSH2 0x38A JUMP JUMPDEST POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 PUSH1 0x1F DUP4 ADD SLT PUSH2 0x140 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 CALLDATALOAD PUSH2 0x150 DUP5 DUP3 PUSH1 0x20 DUP7 ADD PUSH2 0x94 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 PUSH1 0x1F DUP4 ADD SLT PUSH2 0x16A JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST DUP2 CALLDATALOAD PUSH2 0x17A DUP5 DUP3 PUSH1 0x20 DUP7 ADD PUSH2 0xF1 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x195 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP3 ADD CALLDATALOAD PUSH8 0xFFFFFFFFFFFFFFFF DUP2 GT ISZERO PUSH2 0x1AF JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x1BB DUP5 DUP3 DUP6 ADD PUSH2 0x12F JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1D0 DUP4 DUP4 PUSH2 0x24D JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1E3 DUP3 PUSH2 0x345 JUMP JUMPDEST PUSH2 0x1ED DUP2 DUP6 PUSH2 0x368 JUMP JUMPDEST SWAP4 POP DUP4 PUSH1 0x20 DUP3 MUL DUP6 ADD PUSH2 0x1FF DUP6 PUSH2 0x335 JUMP JUMPDEST DUP1 PUSH1 0x0 JUMPDEST DUP6 DUP2 LT ISZERO PUSH2 0x23B JUMPI DUP5 DUP5 SUB DUP10 MSTORE DUP2 MLOAD PUSH2 0x21C DUP6 DUP3 PUSH2 0x1C4 JUMP JUMPDEST SWAP5 POP PUSH2 0x227 DUP4 PUSH2 0x35B JUMP JUMPDEST SWAP3 POP PUSH1 0x20 DUP11 ADD SWAP10 POP POP PUSH1 0x1 DUP2 ADD SWAP1 POP PUSH2 0x203 JUMP JUMPDEST POP DUP3 SWAP8 POP DUP8 SWAP6 POP POP POP POP POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x258 DUP3 PUSH2 0x350 JUMP JUMPDEST PUSH2 0x262 DUP2 DUP6 PUSH2 0x379 JUMP JUMPDEST SWAP4 POP PUSH2 0x272 DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0x399 JUMP JUMPDEST PUSH2 0x27B DUP2 PUSH2 0x3FB JUMP JUMPDEST DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x2A0 DUP2 DUP5 PUSH2 0x1D8 JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 MLOAD SWAP1 POP DUP2 DUP2 ADD DUP2 DUP2 LT PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT OR ISZERO PUSH2 0x2CF JUMPI PUSH2 0x2CE PUSH2 0x3CC JUMP JUMPDEST JUMPDEST DUP1 PUSH1 0x40 MSTORE POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT ISZERO PUSH2 0x2F4 JUMPI PUSH2 0x2F3 PUSH2 0x3CC JUMP JUMPDEST JUMPDEST PUSH1 0x20 DUP3 MUL SWAP1 POP PUSH1 0x20 DUP2 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT ISZERO PUSH2 0x320 JUMPI PUSH2 0x31F PUSH2 0x3CC JUMP JUMPDEST JUMPDEST PUSH1 0x1F NOT PUSH1 0x1F DUP4 ADD AND SWAP1 POP PUSH1 0x20 DUP2 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST DUP3 DUP2 DUP4 CALLDATACOPY PUSH1 0x0 DUP4 DUP4 ADD MSTORE POP POP POP JUMP JUMPDEST PUSH1 0x0 JUMPDEST DUP4 DUP2 LT ISZERO PUSH2 0x3B7 JUMPI DUP1 DUP3 ADD MLOAD DUP2 DUP5 ADD MSTORE PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0x39C JUMP JUMPDEST DUP4 DUP2 GT ISZERO PUSH2 0x3C6 JUMPI PUSH1 0x0 DUP5 DUP5 ADD MSTORE JUMPDEST POP POP POP POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x41 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x1F NOT PUSH1 0x1F DUP4 ADD AND SWAP1 POP SWAP2 SWAP1 POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 PUSH11 0xC92485852808DE0BD8F2C8 0xA8 0xC3 SWAP14 0xD9 LT JUMP 0x26 0xDD 0xAC PUSH9 0x34C4433DFD0586F918 0xAC PUSH5 0x736F6C6343 STOP ADDMOD STOP STOP CALLER \",\n"
            + "\t\"sourceMap\": \"69:313:0:-:0;;;;;;;;;;;;;;;;;;;\"\n"
            + "}";

    public static final String FUNC_BROADCAST = "Broadcast";

    public static final Event PUBLISHED_EVENT = new Event("Published", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
    ;

    @Deprecated
    protected Broadcast(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Broadcast(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Broadcast(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Broadcast(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<PublishedEventResponse> getPublishedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(PUBLISHED_EVENT, transactionReceipt);
        ArrayList<PublishedEventResponse> responses = new ArrayList<PublishedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            PublishedEventResponse typedResponse = new PublishedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.DataOnTheBoard = (List<String>) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PublishedEventResponse> publishedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PublishedEventResponse>() {
            @Override
            public PublishedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(PUBLISHED_EVENT, log);
                PublishedEventResponse typedResponse = new PublishedEventResponse();
                typedResponse.log = log;
                typedResponse.DataOnTheBoard = (List<String>) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PublishedEventResponse> publishedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PUBLISHED_EVENT));
        return publishedEventFlowable(filter);
    }

    public RemoteCall<TransactionReceipt> Broadcast(List<String> broadcastData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BROADCAST, 
                Arrays.<Type>asList(new DynamicArray<Utf8String>(
                        Utf8String.class,
                        org.web3j.abi.Utils.typeMap(broadcastData, Utf8String.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Broadcast load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Broadcast(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Broadcast load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Broadcast(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Broadcast load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Broadcast(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Broadcast load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Broadcast(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Broadcast> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Broadcast.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Broadcast> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Broadcast.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Broadcast> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Broadcast.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Broadcast> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Broadcast.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class PublishedEventResponse {
        public Log log;

        public List<String> DataOnTheBoard;
    }
}
