package graphql.language;


import java.util.ArrayList;
import java.util.List;

import graphql.util.TraversalControl;
import graphql.util.TraverserContext;

public class ObjectValue extends AbstractNode<ObjectValue> implements Value<ObjectValue> {

    private final List<ObjectField> objectFields = new ArrayList<>();

    public ObjectValue() {
    }

    public ObjectValue(List<ObjectField> objectFields) {
        this.objectFields.addAll(objectFields);
    }

    public List<ObjectField> getObjectFields() {
        return objectFields;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(objectFields);
    }

    @Override
    public boolean isEqualTo(Node o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectValue that = (ObjectValue) o;

        return true;

    }

    @Override
    public ObjectValue deepCopy() {
        return new ObjectValue(deepCopy(objectFields));
    }


    @Override
    public String toString() {
        return "ObjectValue{" +
                "objectFields=" + objectFields +
                '}';
    }

    @Override
    public TraversalControl accept(TraverserContext<Node> context, NodeVisitor visitor) {
        return visitor.visitObjectValue(this, context);
    }
}
