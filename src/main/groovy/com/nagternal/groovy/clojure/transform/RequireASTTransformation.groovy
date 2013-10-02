package com.nagternal.groovy.clojure.transform

import clojure.lang.RT
import clojure.lang.Var
import com.nagternal.groovy.clojure.Clj
import org.codehaus.groovy.GroovyBugError
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ClassExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.expr.ExpressionTransformer
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.objectweb.asm.Opcodes

/**
 * User: Dylan
 * Date: 9/30/13
 * Time: 9:08 PM
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class RequireASTTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        if (nodes.length != 2 || !(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof AnnotatedNode)) {
            throw new GroovyBugError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: ${nodes}")
        }
        AnnotatedNode targetField =  nodes[1]
        AnnotationNode annotation = nodes[0]
        if (!(targetField instanceof FieldNode)) {
            throw new GroovyBugError("Field annotation ${annotation.classNode.name} not annotating Field.")
        }
        final FieldNode fieldNode = targetField

        String varName = getVarName(annotation)
        String ns, name
        (ns, name) = Clj.nsname(varName)

        if (!fieldNode.static) { fieldNode.modifiers += Opcodes.ACC_STATIC  }
        if (!fieldNode.final) { fieldNode.modifiers += Opcodes.ACC_FINAL  }
        fieldNode.initialValueExpression =  new StaticMethodCallExpression(
                        new ClassNode(RT), 'var', new ArgumentListExpression(new ConstantExpression(ns), new ConstantExpression(name))
                )
    }

    String getVarName(AnnotationNode annotation) {
        ConstantExpression expr = annotation.getMember('value')
        expr.getValue()
    }
}
